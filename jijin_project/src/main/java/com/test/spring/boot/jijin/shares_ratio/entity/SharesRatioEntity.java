package com.test.spring.boot.jijin.shares_ratio.entity;

import java.math.BigDecimal;

public class SharesRatioEntity {

	private String sharesName;
	private BigDecimal holdingRatio;
	public SharesRatioEntity() {
		super();
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
