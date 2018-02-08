package com.test.spring.boot.jijin.dataimport.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
* @author leiyong E-mail:
* @version 创建时间：2018年2月8日 下午9:11:50
* 类说明
*		
*/
public class DataEntity {
	private String fundId;
	private String fundName;
	private int top10;
	private Date date;
	private String sharesId;
	private String sharesName;
	private BigDecimal holdingRatio;
	public DataEntity() {
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
