package com.test.spring.boot.jijin.fund_shares.entity;

import java.math.BigDecimal;

/**
* @author leiyong E-mail:
* @version 创建时间：2018年2月3日 下午2:53:33
* 类说明
*		
*/
public class FundSharesEntity {
	
	private String fundId;
	private String sharesId;
	private BigDecimal holdingRatio;
	public FundSharesEntity() {
		super();
	}
	public String getFundId() {
		return fundId;
	}
	public void setFundId(String fundId) {
		this.fundId = fundId;
	}
	public String getSharesId() {
		return sharesId;
	}
	public void setSharesId(String sharesId) {
		this.sharesId = sharesId;
	}
	public BigDecimal getHoldingRatio() {
		return holdingRatio;
	}
	public void setHoldingRatio(BigDecimal holdingRatio) {
		this.holdingRatio = holdingRatio;
	}
	
}
