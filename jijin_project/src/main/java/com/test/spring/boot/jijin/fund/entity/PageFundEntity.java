package com.test.spring.boot.jijin.fund.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PageFundEntity {
	
	private String fundId;
	private String fundName;
	private int top10;
	private Date date;
	private String sharesId;
	private String sharesName;
	private BigDecimal holdingRatio;
	
	public PageFundEntity() {
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

	public int getTop10() {
		return top10;
	}

	public void setTop10(int top10) {
		this.top10 = top10;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
