package com.test.spring.boot.jijin.dataimport.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.test.spring.boot.jijin.common.entity.ReturnCode;
import com.test.spring.boot.jijin.common.util.FileImportUtil;
import com.test.spring.boot.jijin.dataimport.service.DataService;
import com.test.spring.boot.jijin.fund.entity.FundEntity;
import com.test.spring.boot.jijin.fund_shares.entity.FundSharesEntity;
import com.test.spring.boot.jijin.shares.entity.SharesEntity;

/**
* @author leiyong E-mail:
* @version 创建时间：2018年2月8日 下午9:16:51
* 类说明
*		
*/
@Service
public class DataServiceImpl implements DataService{

	@Override
	public String importData(HttpServletRequest request) {
		try {
	         MultipartRequest multipartRequest=(MultipartRequest) request;
	         MultipartFile excelFile=multipartRequest.getFile("excelFile");
	         if(excelFile!=null){
	             List<List<String>> datas = FileImportUtil.readExcel(excelFile);
	             for (List<String> list : datas) {
	            	 FundEntity fund = createFundEntity(list);
	            	 SharesEntity shares = createSharesEntity(list);
	            	 FundSharesEntity fundShare = createFundSharesEntity(list);
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

}
