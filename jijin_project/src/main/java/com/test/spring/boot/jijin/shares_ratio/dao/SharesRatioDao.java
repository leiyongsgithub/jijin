package com.test.spring.boot.jijin.shares_ratio.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.test.spring.boot.jijin.shares_ratio.entity.SharesRatioEntity;

@Mapper
public interface SharesRatioDao {
	
	void saveBatch(@Param("dataMap")Map map);
	
	void saveData();
	
	void empty();
	
	List<SharesRatioEntity> page();

	Integer count(String shareName);
}
