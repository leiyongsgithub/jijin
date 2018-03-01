package com.test.spring.boot.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Publisher {
	
	private JedisPool pool;
	private String channel = "leiyong";
	
	public Publisher(JedisPool pool, String channel) {
		super();
		this.pool = pool;
		this.channel = channel;
	}

	public JedisPool getPool() {
		return pool;
	}

	public void setPool(JedisPool pool) {
		this.pool = pool;
	}
	
	public void publish(){
		 Jedis jedis = pool.getResource();
		 for(int i=0;i<10;i++){
			 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 jedis.publish(channel, "message : "+i);
		 }
	}
}
