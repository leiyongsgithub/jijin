package com.test.spring.boot.jijin.fund.entity;

import java.time.LocalDate;
import java.util.Date;

/**
* @author leiyong E-mail:
* @version 创建时间：2018年2月3日 下午2:34:03
* 类说明
*		
*/
public class FundEntity {
	private String fundId;
	private String fundName;
	private int top10;
	private Date date;
	public FundEntity() {
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
	
}
