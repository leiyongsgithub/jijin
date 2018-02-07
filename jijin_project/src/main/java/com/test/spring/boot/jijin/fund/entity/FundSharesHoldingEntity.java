package com.test.spring.boot.jijin.fund.entity;

import java.util.List;

public class FundSharesHoldingEntity{
	private String fundId;
	private String fundName;
	private List<HoldingSharesEntity> children;
	public FundSharesHoldingEntity() {
		super();
	}
	public String getFundId() {
		return fundId;
	}
	public void setFundId(String fundId) {
		this.fundId = fundId;
	}
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public List<HoldingSharesEntity> getChildren() {
		return children;
	}
	public void setChildren(List<HoldingSharesEntity> children) {
		this.children = children;
	}
	
	
}
