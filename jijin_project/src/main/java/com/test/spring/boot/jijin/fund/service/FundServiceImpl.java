package com.test.spring.boot.jijin.fund.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.test.spring.boot.jijin.common.entity.ReturnCode;
import com.test.spring.boot.jijin.common.util.FileImportUtil;
import com.test.spring.boot.jijin.fund.dao.FundDao;
import com.test.spring.boot.jijin.fund.entity.FundEntity;
import com.test.spring.boot.jijin.fund.entity.PageFundEntity;
import com.test.spring.boot.jijin.fund.param.PageParam;
import com.test.spring.boot.jijin.fund_shares.dao.FundSharesDao;
import com.test.spring.boot.jijin.fund_shares.entity.FundSharesEntity;
import com.test.spring.boot.jijin.shares.dao.SharesDao;
import com.test.spring.boot.jijin.shares.entity.SharesEntity;

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
		entity.setSharesId(param.get(4));
		entity.setHoldingRatio(new BigDecimal(param.get(6)));
		return entity;
	}

	@Override
	public List<PageFundEntity> pageQuery(PageParam param) {
		return fundDao.pageQuery(param);
	}
	
	
	
}
