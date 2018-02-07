package com.test.spring.boot.jijin.fund.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.test.spring.boot.jijin.fund.entity.FundEntity;
import com.test.spring.boot.jijin.fund.entity.PageFundEntity;
import com.test.spring.boot.jijin.fund.param.PageParam;

/**
* @author leiyong E-mail:
* @version 创建时间：2018年2月3日 下午2:25:36
* 类说明
*		
*/
public interface FundService {
	//导入
	String importData(HttpServletRequest request);
	//页面查询
	List<PageFundEntity> pageQuery(PageParam param);
	/*
	 * 定时任务
	 * 将 fund shares fund_shares 表的数据  统计进入  holding_statistics
	*/
	void holdingStatistics();
	
	void test();
}
