package com.test.spring.boot.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
	
	public static void main(String[] args) {
		Map<String,Integer> map = new ConcurrentHashMap<>();
		map.put("two", 2);map.put("one", 1);map.put("three", 3);
		System.out.println(map.values());
	}
}
