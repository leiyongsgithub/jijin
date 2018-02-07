package com.test.spring.boot.jijin.fund.entity;

import java.math.BigDecimal;

public class HoldingSharesEntity {

	private String sharesId;
	private String sharesName;
	private BigDecimal holdingRatio;
	public HoldingSharesEntity() {
		super();
	}
	public String getSharesId() {
		return sharesId;
	}
	public void setSharesId(String sharesId) {
		this.sharesId = sharesId;
	}
	public String getSharesName() {
		return sharesName;
	}
	public void setSharesName(String sharesName) {
		this.sharesName = sharesName;
	}
	public BigDecimal getHoldingRatio() {
		return holdingRatio;
	}
	public void setHoldingRatio(BigDecimal holdingRatio) {
		this.holdingRatio = holdingRatio;
	}
	
}
