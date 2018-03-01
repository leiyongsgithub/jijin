package com.test.spring.boot.jedis;

import redis.clients.jedis.JedisPubSub;

public class Subscriber  extends JedisPubSub  {
	@Override
    public void onMessage(String channel, String message) {
        // TODO Auto-generated method stub
        System.out.println(channel + "," + message);
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        // TODO Auto-generated method stub
        System.out.println(pattern + "," + channel + "," + message);

    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        // TODO Auto-generated method stub
        System.out.println("onSubscribe: channel[" + channel + "]," + "subscribedChannels[" + subscribedChannels + "]");
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        // TODO Auto-generated method stub
        System.out.println(
                "onUnsubscribe: channel[" + channel + "], " + "subscribedChannels[" + subscribedChannels + "]");
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        // TODO Auto-generated method stub
        System.out.println("onPUnsubscribe: pattern[" + pattern + "]," +

                "subscribedChannels[" + subscribedChannels + "]");

    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPSubscribe: pattern[" + pattern + "], " +

                "subscribedChannels[" + subscribedChannels + "]");

    }
}
