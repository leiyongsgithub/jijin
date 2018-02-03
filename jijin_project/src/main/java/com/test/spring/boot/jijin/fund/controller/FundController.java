package com.test.spring.boot.jijin.fund.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.alibaba.fastjson.JSONObject;
import com.test.spring.boot.jijin.entity.ReturnCode;
import com.test.spring.boot.jijin.fund.service.FundService;
import com.test.spring.boot.jijin.util.FileImportUtil;

/**
* @author leiyong E-mail:
* @version 创建时间：2018年2月3日 下午2:24:56
* 类说明
*		
*/
@RequestMapping("/fund")
@RestController
public class FundController {
	
	@Autowired
	private FundService fundService;
	
	@RequestMapping("/import")
	public String importData(HttpServletRequest request){
		return fundService.importData(request);
	}
	
	
}
