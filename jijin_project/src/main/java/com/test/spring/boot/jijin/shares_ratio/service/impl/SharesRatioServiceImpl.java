package com.test.spring.boot.jijin.shares_ratio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.spring.boot.jijin.shares_ratio.dao.SharesRatioDao;
import com.test.spring.boot.jijin.shares_ratio.entity.SharesRatioEntity;
import com.test.spring.boot.jijin.shares_ratio.service.SharesRatioService;

@Service
public class SharesRatioServiceImpl implements SharesRatioService{
	
	@Autowired
	private SharesRatioDao sharesRatioDao;

	@Override
	public List<SharesRatioEntity> page() {
		return sharesRatioDao.page();
	}
	
	
}
