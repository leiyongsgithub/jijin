package com.test.spring.boot.jijin.dataimport.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.spring.boot.jijin.dataimport.service.DataService;

/**
* @author leiyong E-mail:
* @version 创建时间：2018年2月8日 下午9:13:22
* 类说明
*		
*/
@RestController
@RequestMapping("/data")
public class DataController {
	
	@Autowired
	private DataService dataservice;
	
	
	@RequestMapping("/import")
	public String importData(HttpServletRequest request){
		return dataservice.importData(request);
	}
}
