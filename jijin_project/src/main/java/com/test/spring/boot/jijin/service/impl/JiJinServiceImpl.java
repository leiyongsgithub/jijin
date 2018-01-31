package com.test.spring.boot.jijin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.spring.boot.jijin.dao.JiJinDao;
import com.test.spring.boot.jijin.entity.TestParam;
import com.test.spring.boot.jijin.service.JiJinService;

@Service
public class JiJinServiceImpl implements JiJinService{
	@Autowired
	private JiJinDao jiJinDao;
	
	@Override
	public String test(TestParam param) {
		// TODO Auto-generated method stub
		return jiJinDao.test(param);
	}
	
}
