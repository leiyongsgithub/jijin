package com.test.spring.boot.jijin.fund.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.spring.boot.jijin.fund.entity.PageFundEntity;
import com.test.spring.boot.jijin.fund.param.PageParam;
import com.test.spring.boot.jijin.fund.service.FundService;

/**
* @author leiyong E-mail:
* @version 创建时间：2018年2月3日 下午2:24:56
* 类说明
*		
*/
@RequestMapping("/fund")
@RestController
public class FundController {
	
	@Autowired
	private FundService fundService;
	
	@RequestMapping("/import")
	public String importData(HttpServletRequest request){
		return fundService.importData(request);
	}
	
	@RequestMapping("/page")
	public List<PageFundEntity> pageQuery(PageParam param){
		List<PageFundEntity> res = fundService.pageQuery(param);
		return res;
	}
	@RequestMapping("/test")
	public void test(){
		fundService.test();
	}
}
