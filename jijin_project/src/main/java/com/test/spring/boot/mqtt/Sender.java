package com.test.spring.boot.mqtt;

import java.net.URISyntaxException;

import org.fusesource.mqtt.client.FutureConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;
import org.fusesource.mqtt.client.Topic;

/**
 * 
 * 
 * 
 * 閲囩敤Future寮� 鍙戝竷涓婚
 * 
 * @author longgangbai
 */
public class Sender {
	private final static String CONNECTION_STRING = "tcp://localhost:1883";
	private final static boolean CLEAN_START = true;
	private final static short KEEP_ALIVE = 30;// 浣庤�楃綉缁滐紝浣嗘槸鍙堥渶瑕佸強鏃惰幏鍙栨暟鎹紝蹇冭�?30s
	public final static long RECONNECTION_ATTEMPT_MAX = 6;
	public final static long RECONNECTION_DELAY = 2000;

	public final static int SEND_BUFFER_SIZE = 2 * 1024 * 1024;// 鍙戦�佹渶澶х紦鍐蹭负2M

	public static void main(String[] args) {
		MQTT mqtt = new MQTT();
		try {
			// 璁剧疆鏈嶅姟绔殑ip
			mqtt.setHost(CONNECTION_STRING);
			// 杩炴帴鍓嶆竻绌轰細璇濅俊鎭�
			mqtt.setCleanSession(CLEAN_START);
			// 璁剧疆閲嶆柊杩炴帴鐨勬鏁�
			mqtt.setReconnectAttemptsMax(RECONNECTION_ATTEMPT_MAX);
			// 璁剧疆閲嶈繛鐨勯棿闅�?椂闂�?
			mqtt.setReconnectDelay(RECONNECTION_DELAY);
			// 璁剧疆蹇冭烦鏃堕�?
			mqtt.setKeepAlive(KEEP_ALIVE);
			// 璁剧疆缂撳啿鐨勫ぇ灏�?
			mqtt.setSendBufferSize(SEND_BUFFER_SIZE);
			mqtt.setUserName("admin");
			mqtt.setPassword("activemq");
			// 鍒涘缓杩炴帴
			final FutureConnection connection = mqtt.futureConnection();
			connection.connect();
			int count = 0;
			while (2 > count) {
				count++;
				// 鐢ㄤ簬鍙戝竷娑堟伅锛�?洰鍓嶆墜鏈烘涓嶉渶瑕佸悜鏈嶅姟绔彂閫佹秷鎭�
				// 涓婚鐨勫唴瀹�
				String message = "leiyong send this" + count;
				String topic = "leiyong-moquette";
				connection.publish(topic, message.getBytes(), QoS.EXACTLY_ONCE, false);
				System.out.println(
						"MQTTFutureServer.publish Message " + "Topic Title :" + topic + " context :" + message);
			}
			Thread.sleep(100000);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}