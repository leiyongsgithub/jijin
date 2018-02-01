package com.test.spring.boot.jijin.entity;

import lombok.Data;

@Data
public class TestParam {
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
