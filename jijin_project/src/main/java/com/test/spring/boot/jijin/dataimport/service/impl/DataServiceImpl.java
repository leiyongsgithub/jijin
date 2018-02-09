package com.test.spring.boot.jijin.dataimport.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.parser.Entity;

import org.omg.PortableServer.ServantActivator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.test.spring.boot.jijin.common.entity.Constant;
import com.test.spring.boot.jijin.common.entity.ReturnCode;
import com.test.spring.boot.jijin.common.util.FileImportUtil;
import com.test.spring.boot.jijin.dataimport.dao.DataDao;
import com.test.spring.boot.jijin.dataimport.entity.DataEntity;
import com.test.spring.boot.jijin.dataimport.param.DataParam;
import com.test.spring.boot.jijin.dataimport.service.DataService;
import com.test.spring.boot.jijin.shares_ratio.dao.SharesRatioDao;

/**
* @author leiyong E-mail:
* @version 创建时间：2018年2月8日 下午9:16:51
* 类说明
*		
*/
@Service
public class DataServiceImpl implements DataService{

	@Autowired
	private DataDao dataDao;
	@Autowired
	SharesRatioDao sharesRatioDao;
	private static int score ;
	@Override
	public List<DataEntity> page() {
		List<DataEntity> list = dataDao.page(new DataParam());
		list.stream().forEach(Entity -> SetScore(Entity));
		return list;
	}

	private void SetScore(DataEntity dataEntity) {
		if(dataEntity != null && dataEntity.getTop10() == 0 
				&& dataEntity.getFundId() != null) {
			score = 0;
			dataEntity.setScore(count(dataEntity.getFundId()));
		}
	}

	private Integer count(String fundId) {
		/*
		 * 1.获取 fundId 所有的持仓
		 */
		DataParam param = new DataParam();
		param.setFundId(fundId);
		List<DataEntity> list = dataDao.page(param);
		/*
		 * 2.遍历持仓股票 ，并计算得分
		 * 规则：
		 * 		2-1: 所持仓股票，没有在top10基金持仓股票中出现
		 * 			 2-1-2：所持仓股票比例达到  ONE_LEVEL_RATIO 减去  ONE_LEVEL_SCORE 分数；类推 two three
		 * 		2-2: 所持仓股票，在top10基金持仓股票中出现
		 * 			 2-2-2：所持仓股票比例达到  ONE_LEVEL_RATIO 加上  ONE_LEVEL_SCORE 分数；类推 two three
		 */
		for (DataEntity dataEntity : list) {
			Integer flag = sharesRatioDao.count(dataEntity.getShareName());
			if(flag == null || flag == 0){
				BigDecimal ratio = dataEntity.getHoldingRatio();
				if(ratio.compareTo(new BigDecimal(Constant.THREE_LEVEL_RATIO))>0){
					score = score - Constant.THREE_LEVEL_SCORE;
					continue;
				}
				if(ratio.compareTo(new BigDecimal(Constant.TWO_LEVEL_RATIO))>0){
					score = score - Constant.TWO_LEVEL_SCORE;
					continue;
				}
				if(ratio.compareTo(new BigDecimal(Constant.ONE_LEVEL_RATIO))>0){
					score = score - Constant.ONE_LEVEL_SCORE;
				}
				continue;
			}
			BigDecimal ratio = dataEntity.getHoldingRatio();
			if(ratio.compareTo(new BigDecimal(Constant.THREE_LEVEL_RATIO))>0){
				score = score + Constant.THREE_LEVEL_SCORE;
				continue;
			}
			if(ratio.compareTo(new BigDecimal(Constant.TWO_LEVEL_RATIO))>0){
				score = score + Constant.TWO_LEVEL_SCORE;
				continue;
			}
			if(ratio.compareTo(new BigDecimal(Constant.ONE_LEVEL_RATIO))>0){
				score = score + Constant.ONE_LEVEL_SCORE;
				continue;
			}
		}
		return score;
	}

	@Override
	@Transactional
	public String importData(HttpServletRequest request) {
		try {
	         MultipartRequest multipartRequest=(MultipartRequest) request;
	         MultipartFile excelFile=multipartRequest.getFile("excelFile");
	         if(excelFile!=null){
	             List<List<String>> datas = FileImportUtil.readExcel(excelFile);
	             for (List<String> list : datas) {
	            	DataEntity entity = createDataEntity(list);
	            	dataDao.save(entity);
	             }
	             sharesRatioDao.empty();
	             sharesRatioDao.saveData();
	             return ReturnCode.success.name();
	         }else{
	             return ReturnCode.paramErr.name();
	         }
	     } catch (Exception e) {
	    	 e.printStackTrace();
	         return ReturnCode.systemErr.name();
	     }
	}

	private DataEntity createDataEntity(List<String> list) {
		DataEntity entity = new DataEntity();
		entity.setFundId(list.get(0));
		entity.setFundName(list.get(1));
		entity.setTop10((int)Math.round(Double.parseDouble(list.get(2))));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		try {
			entity.setDate(sdf.parse(list.get(3)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		entity.setShareId(list.get(4));
		entity.setShareName(list.get(5));
		entity.setHoldingRatio(new BigDecimal(list.get(6)));
		return entity;
	}
	
	
}
