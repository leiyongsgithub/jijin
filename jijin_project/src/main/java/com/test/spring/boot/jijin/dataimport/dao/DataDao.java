package com.test.spring.boot.jijin.dataimport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.spring.boot.jijin.dataimport.entity.DataEntity;
import com.test.spring.boot.jijin.dataimport.param.DataParam;

@Mapper
public interface DataDao {
	
	void save(DataEntity entity);

	List<DataEntity> page(DataParam dataParam);

}
