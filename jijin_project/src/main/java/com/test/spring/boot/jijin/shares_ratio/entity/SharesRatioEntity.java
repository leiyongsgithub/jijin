package com.test.spring.boot.jijin.shares_ratio.entity;

import java.math.BigDecimal;

public class SharesRatioEntity {

	private String shareName;
	private BigDecimal holdingRatio;
	public SharesRatioEntity() {
		super();
	}
	public String getShareName() {
		return shareName;
	}
	public void setShareName(String shareName) {
		this.shareName = shareName;
	}
	public BigDecimal getHoldingRatio() {
		return holdingRatio;
	}
	public void setHoldingRatio(BigDecimal holdingRatio) {
		this.holdingRatio = holdingRatio;
	}
	
}
