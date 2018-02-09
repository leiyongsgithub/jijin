package com.test.spring.boot.jijin.dataimport.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.test.spring.boot.jijin.dataimport.entity.DataEntity;

/**
* @author leiyong E-mail:
* @version 创建时间：2018年2月8日 下午9:16:28
* 类说明
*		
*/
public interface DataService {

	String importData(HttpServletRequest request);

	List<DataEntity> page();

}
