package com.test.spring.boot.jijin.entity;
/**
* @author leiyong E-mail:
* @version 创建时间：2018年2月1日 下午9:41:31
* 类说明
*		
*/
public enum ReturnCode {
	success(1000),
	paramErr(100),
	systemErr(101);
	
	public int code;


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	private ReturnCode(int code) {
		this.code = code;
	}
	
	
}
