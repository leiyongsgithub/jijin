package com.test.spring.boot.jijin.dao;

import org.apache.ibatis.annotations.Mapper;

import com.test.spring.boot.jijin.entity.TestParam;

@Mapper
public interface JiJinDao {

	String test(TestParam param);

}
