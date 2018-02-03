package com.test.spring.boot.jijin.shares.dao;
/**
* @author leiyong E-mail:
* @version 创建时间：2018年2月3日 下午2:48:39
* 类说明
*		
*/

import org.apache.ibatis.annotations.Mapper;

import com.test.spring.boot.jijin.shares.entity.SharesEntity;

@Mapper
public interface SharesDao {
	
	void save(SharesEntity entity);
}
