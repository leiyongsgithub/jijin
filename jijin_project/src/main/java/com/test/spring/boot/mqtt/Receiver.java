package com.test.spring.boot.mqtt;  
  
import java.net.URISyntaxException;

import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.CallbackConnection;
import org.fusesource.mqtt.client.Future;  
import org.fusesource.mqtt.client.FutureConnection;  
import org.fusesource.mqtt.client.MQTT;  
import org.fusesource.mqtt.client.Message;  
import org.fusesource.mqtt.client.QoS;  
import org.fusesource.mqtt.client.Topic;  
/** 
 *  
 * MQTT moquette 鐨凜lient 娈电敤浜庤闃呬富棰橈紝骞舵帴鏀朵富棰樹俊鎭� 
 *  
 * 閲囩敤Future 寮� 璁㈤槄涓婚  
 *  
 * @author longgangbai 
 */  
public class Receiver {  
        private final static String CONNECTION_STRING = "tcp://localhost:1883";  
        private final static boolean CLEAN_START = true;  
        private final static short KEEP_ALIVE = 30;// 浣庤�楃綉缁滐紝浣嗘槸鍙堥渶瑕佸強鏃惰幏鍙栨暟鎹紝蹇冭烦30s  
        public  static Topic[] topics = {  
                        new Topic("leiyong-moquette", QoS.EXACTLY_ONCE)};  
        public final  static long RECONNECTION_ATTEMPT_MAX=6;  
        public final  static long RECONNECTION_DELAY=2000;  
          
        public final static int SEND_BUFFER_SIZE=2*1024*1024;//鍙戦�佹渶澶х紦鍐蹭负2M  
          
          
          public static void main(String[] args)   {  
                //鍒涘缓MQTT瀵硅薄  
                MQTT mqtt = new MQTT();  
                try {  
                    //璁剧疆mqtt broker鐨刬p鍜岀鍙�  
                    mqtt.setHost(CONNECTION_STRING);  
                    //杩炴帴鍓嶆竻绌轰細璇濅俊鎭�  
                    mqtt.setCleanSession(CLEAN_START);  
                    //璁剧疆閲嶆柊杩炴帴鐨勬鏁�  
                    mqtt.setReconnectAttemptsMax(RECONNECTION_ATTEMPT_MAX);  
                    //璁剧疆閲嶈繛鐨勯棿闅旀椂闂�  
                    mqtt.setReconnectDelay(RECONNECTION_DELAY);  
                    //璁剧疆蹇冭烦鏃堕棿  
                    mqtt.setKeepAlive(KEEP_ALIVE);  
                    //璁剧疆缂撳啿鐨勫ぇ灏�  
                    mqtt.setSendBufferSize(SEND_BUFFER_SIZE);
                    mqtt.setUserName("admin");
                    mqtt.setPassword("activemq");
                    //鑾峰彇mqtt鐨勮繛鎺ュ璞lockingConnection  
                    final FutureConnection connection= mqtt.futureConnection();  
                    final BlockingConnection blockingConnection = mqtt.blockingConnection();
                    final CallbackConnection callbackConnection = mqtt.callbackConnection();
                    connection.connect();  
                    connection.subscribe(topics);  
                    
//                    blockingConnection.connect();
//                    blockingConnection.subscribe(topics);
                    while(true){  
                    	System.out.println("--*-------*-------*--");
                        Future<Message> futrueMessage=connection.receive();  
                        Message message =futrueMessage.await();  
                        System.out.println(new String(message.getPayloadBuffer().getData()));
                        System.out.println("MQTTFutureClient.Receive Message "+ "Topic Title :"+message.getTopic()+" context :"+new String(message.getPayloadBuffer().getData()));  
                        
//                    	Message message =  blockingConnection.receive();
//                    	System.out.println(new String(message.getPayloadBuffer().getData()));
                    }  
                } catch (URISyntaxException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                } catch (Exception e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }finally{  
                      
                }  
            }  
}  