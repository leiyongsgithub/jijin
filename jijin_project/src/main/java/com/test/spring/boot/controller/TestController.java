package com.test.spring.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class TestController {
	
	@GetMapping("/test")
	public String test(String param){
		
		return "得到回复 : "+param;
	}
}
