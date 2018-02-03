package com.test.spring.boot.jijin.fund_shares.dao;

import org.apache.ibatis.annotations.Mapper;

import com.test.spring.boot.jijin.fund_shares.entity.FundSharesEntity;

/**
* @author leiyong E-mail:
* @version 创建时间：2018年2月3日 下午2:53:10
* 类说明
*		
*/
@Mapper
public interface FundSharesDao {
	
	void save(FundSharesEntity entity);
}
