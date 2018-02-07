package com.test.spring.boot.jijin.fund.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.test.spring.boot.jijin.common.entity.Constant;
import com.test.spring.boot.jijin.common.entity.ReturnCode;
import com.test.spring.boot.jijin.common.util.CheckUtil;
import com.test.spring.boot.jijin.common.util.FileImportUtil;
import com.test.spring.boot.jijin.fund.dao.FundDao;
import com.test.spring.boot.jijin.fund.entity.FundEntity;
import com.test.spring.boot.jijin.fund.entity.FundSharesHoldingEntity;
import com.test.spring.boot.jijin.fund.entity.HoldingSharesEntity;
import com.test.spring.boot.jijin.fund.entity.PageFundEntity;
import com.test.spring.boot.jijin.fund.param.PageParam;
import com.test.spring.boot.jijin.fund_shares.dao.FundSharesDao;
import com.test.spring.boot.jijin.fund_shares.entity.FundSharesEntity;
import com.test.spring.boot.jijin.shares.dao.SharesDao;
import com.test.spring.boot.jijin.shares.entity.SharesEntity;
import com.test.spring.boot.jijin.shares_ratio.dao.SharesRatioDao;
import com.test.spring.boot.jijin.shares_ratio.entity.SharesRatioEntity;

/**
* @author leiyong E-mail:
* @version 创建时间：2018年2月3日 下午2:26:02
* 类说明
*		
*/
@Service
public class FundServiceImpl implements FundService{
	
	@Autowired
	private FundDao fundDao;
	@Autowired
	private SharesDao sharesDao;
	@Autowired
	private FundSharesDao fundSharesDao;
	@Autowired
	private SharesRatioDao sharesRatioDao;
	
	public static Set dataSet = new ConcurrentSkipListSet<String>();

	@Override
	@Transactional
	public String importData(HttpServletRequest request) {
		int count;
		try {
	         MultipartRequest multipartRequest=(MultipartRequest) request;
	         MultipartFile excelFile=multipartRequest.getFile("excelFile");
	         if(excelFile!=null){
	             List<List<String>> datas = FileImportUtil.readExcel(excelFile);
	             for (List<String> list : datas) {
	            	 FundEntity fund = createFundEntity(list);
	            	 SharesEntity shares = createSharesEntity(list);
	            	 FundSharesEntity fundShare = createFundSharesEntity(list);
	            	 count = dataSet.size();
	            	 dataSet.add(fund.getFundId());
	            	 if(dataSet.size()>count){
	            		 fundDao.save(fund);
	            	 }
	            	 sharesDao.save(shares);
	            	 fundSharesDao.save(fundShare);
				}
	             return ReturnCode.success.name();
	         }else{
	             return ReturnCode.paramErr.name();
	         }
	     } catch (Exception e) {
	    	 e.printStackTrace();
	         return ReturnCode.systemErr.name();
	     }finally {
	    	 dataSet.clear();
		}
	}
	
	private FundEntity createFundEntity(List<String> param){
		FundEntity entity = new FundEntity();
		entity.setFundId(param.get(0));
		entity.setFundName(param.get(1));
		entity.setTop10((int)Math.round(Double.parseDouble(param.get(2))));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		try {
			entity.setDate(sdf.parse(param.get(3)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return entity;
	}
	private SharesEntity createSharesEntity(List<String> param){
		SharesEntity entity = new SharesEntity();
		entity.setSharesId(param.get(4));
		entity.setSharesName(param.get(5));
		return entity;
	}
	private FundSharesEntity createFundSharesEntity(List<String> param){
		FundSharesEntity entity = new FundSharesEntity();
		entity.setFundId(param.get(0));
		entity.setSharesName(param.get(5));
		entity.setHoldingRatio(new BigDecimal(param.get(6)));
		return entity;
	}

	@Override
	public List<PageFundEntity> pageQuery(PageParam param) {
		List<PageFundEntity> res = fundDao.pageQuery(param);
		for (PageFundEntity entity : res) {
			int score = setScore(entity.getFundId());
			entity.setScore(score);
		}
		return res;
	}

	@Override
	@Transactional
	public void holdingStatistics() {
		/**
		 * 1.1   定义局部集合 Collection
		 * 1.2   查出最新top10 fund
		 */
		Map<String,BigDecimal> dataMap = new ConcurrentHashMap<>();
		List<HoldingSharesEntity> allChildren = new LinkedList<>();
		List<FundSharesHoldingEntity> list = fundDao.top10_fund_shares_list();
		if(CheckUtil.checkList(list)) return;
		/**
		 * 2.1   遍历top10 获取对应的child
		 * 2.2 allChildren 收集所有child
		 */
		for (FundSharesHoldingEntity entity : list) {
			allChildren.addAll(entity.getChildren());
		}
		/**
		 * 3.1 allChildren 存入 dataMap
		 * 3.2 冲突解决：
		 * 		不同fund持有同一shares的情况：
		 * 			shares保存唯一，holdingRatio求和
		 */
		BigDecimal currentRatio;
		BigDecimal ratio;
		for (HoldingSharesEntity entity : allChildren) {
			String sharesName = entity.getSharesName();
			currentRatio = dataMap.get(sharesName);
			if(currentRatio == null) 
				currentRatio = BigDecimal.ZERO;
			if(entity.getHoldingRatio() == null) 
				entity.setHoldingRatio(BigDecimal.ZERO);
			ratio = currentRatio.add(entity.getHoldingRatio());
			dataMap.put(entity.getSharesName(), ratio);
		}
		sharesRatioDao.saveBatch(dataMap);
	}

	@Override
	public void test() {
		Map<String,BigDecimal> map = new ConcurrentHashMap<>();
		map.put("one", new BigDecimal(0.01));
		map.put("two", new BigDecimal(0.0232));
		sharesRatioDao.saveBatch(map);
	}
	
	
	
	
	/**
	 * 1. 获取fundId 对应的 sharesName list;
	 * 	      获取shares_ratio表 持仓shares list
	 * 2. 遍历sharesName,根据计算规则得到 score
	 * 3. 汇总score
	 */
	public int setScore(String fundId){
		int final_score = 0;
		List<String> sharesNameList = fundDao.findSharesNameByFundId(fundId);
		List<SharesRatioEntity> sharesRatioList =sharesRatioDao.page();
		for (String name : sharesNameList) {
			final_score += countScore(name,sharesRatioList);
		}
		return final_score;
	}
	/**
	 * 计算规则：
	 * 第一档 ：3  10分
	 * 第二档 ：2  5分   
	 * 第三档 ：1  2分
	 * @param sharesRatioList 
	 * @param name 
	 */
	private int countScore(String name, List<SharesRatioEntity> sharesRatioList) {
		SharesRatioEntity entity = sharesRatioList.stream().
				filter(s -> s.getSharesName().equals(name)).findAny().orElse(null);
		if(entity != null){
			if (entity.getHoldingRatio().compareTo(new BigDecimal(Constant.ONE_LEVEL_RATIO))>=0)
				return Constant.ONE_LEVEL_SCORE;
			
			if (entity.getHoldingRatio().compareTo(new BigDecimal(Constant.TWO_LEVEL_RATIO))>=0)
				return Constant.TWO_LEVEL_SCORE;
			
			if (entity.getHoldingRatio().compareTo(new BigDecimal(Constant.THREE_LEVEL_RATIO))>=0)
				return Constant.THREE_LEVEL_SCORE;
		}
		return 0;
	}
}
