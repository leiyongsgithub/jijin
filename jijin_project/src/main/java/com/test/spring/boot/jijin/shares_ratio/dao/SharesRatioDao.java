package com.test.spring.boot.jijin.shares_ratio.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SharesRatioDao {
	
	void saveBatch(@Param("dataMap")Map map);
}
