package com.test.spring.boot.jijin.fund.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.spring.boot.jijin.fund.entity.FundEntity;
import com.test.spring.boot.jijin.fund.entity.FundSharesHoldingEntity;
import com.test.spring.boot.jijin.fund.entity.PageFundEntity;
import com.test.spring.boot.jijin.fund.param.PageParam;

/**
* @author leiyong E-mail:
* @version 创建时间：2018年2月3日 下午2:26:46
* 类说明
*		
*/
@Mapper
public interface FundDao {
	
	void save(FundEntity en);

	List<PageFundEntity> pageQuery(PageParam param);

	List<FundSharesHoldingEntity> top10_fund_shares_list();

	List<String> findSharesNameByFundId(String fundId);
}
