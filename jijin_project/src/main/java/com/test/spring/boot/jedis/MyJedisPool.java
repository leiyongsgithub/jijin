package com.test.spring.boot.jedis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public enum MyJedisPool {
	
	INSTANCE;
	
	private JedisPool pool;
	
	MyJedisPool(){
		String redisIp = "127.0.0.1";
        int reidsPort = 6379;
		pool = new JedisPool(new JedisPoolConfig(), redisIp, reidsPort);
	}
	
	public JedisPool builder(){
        return pool;
	}
	
}
