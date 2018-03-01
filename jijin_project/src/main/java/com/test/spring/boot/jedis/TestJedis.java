package com.test.spring.boot.jedis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestJedis {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(10);
		JedisPool jedisPool = MyJedisPool.INSTANCE.builder();
		
		//1.dingyue
		Jedis jedis = jedisPool.getResource();
		try{
			pool.execute(new Runnable() {
				@Override
				public void run() {
					jedis.subscribe(new Subscriber(), "leiyong");
				}
			});
		}catch (Exception e) {
		}finally {
			pool.shutdown();
		}
		
		//2.fabu
		new Publisher(jedisPool,"leiyong").publish();
	}
}
