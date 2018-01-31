package com.test.spring.boot.jijin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.spring.boot.jijin.entity.TestParam;
import com.test.spring.boot.jijin.service.JiJinService;

@RestController
@RequestMapping("/jijin")
public class JiJinController {
	
	@Autowired
	private JiJinService jiJinService;
	
	@GetMapping("/test")
	public String test(TestParam param){
		
		return jiJinService.test(param);
	}
}
