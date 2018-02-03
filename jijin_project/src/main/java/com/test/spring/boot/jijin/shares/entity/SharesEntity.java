package com.test.spring.boot.jijin.shares.entity;
/**
* @author leiyong E-mail:
* @version 创建时间：2018年2月3日 下午2:49:56
* 类说明
*		
*/
public class SharesEntity {
	
	private String sharesId;
	private String sharesName;
	public SharesEntity() {
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
	
}
