package com.test.spring.boot.jijin.shares_ratio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.spring.boot.jijin.shares_ratio.entity.SharesRatioEntity;
import com.test.spring.boot.jijin.shares_ratio.service.SharesRatioService;

@RestController
@RequestMapping("/shares_ratio")
public class SharesRatioController {
	
	@Autowired
	private SharesRatioService sharesRatioService;
	
	@RequestMapping("/page")
	public List<SharesRatioEntity> page(){
		return sharesRatioService.page();
	}
}
