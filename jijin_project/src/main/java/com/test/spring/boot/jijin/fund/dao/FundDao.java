package com.test.spring.boot.jijin.fund.dao;

import org.apache.ibatis.annotations.Mapper;

import com.test.spring.boot.jijin.fund.entity.FundEntity;

/**
* @author leiyong E-mail:
* @version 创建时间：2018年2月3日 下午2:26:46
* 类说明
*		
*/
@Mapper
public interface FundDao {
	
	void save(FundEntity en);
}
