package com.test.spring.boot.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQObjectMessage;

public class Recive {
	public static void main(String[] args) {
		ConnectionFactory connectionFactory;
		// Connection ：JMS 客户端到JMS Provider 的连接  
		Connection connection = null;
		// Session： 一个发送或接收消息的线程  
		Session session;
		// Destination ：消息的目的地;消息发送给谁.  
		Destination destination;
		// 消费者，消息接收者  
		MessageConsumer consumer;
		String brokerUrl = "tcp://localhost:61616?" +   
                "jms.optimizeAcknowledge=true" +   
                "&jms.optimizeAcknowledgeTimeOut=100" +   
                "&jms.redeliveryPolicy.maximumRedeliveries=6"; 
		ActiveMQConnectionFactory af = new ActiveMQConnectionFactory("admin", "activemq", brokerUrl);
		af.setTrustAllPackages(true);

		connectionFactory = af;
		try {
			// 构造从工厂得到连接对象  
			connection = connectionFactory.createConnection();
			// 启动  
			connection.start();
			// 获取操作连接  
			//这个最好还是有事务
			session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
			// 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置  
			destination = session.createQueue("leiyong");
			consumer = session.createConsumer(destination);
			consumer.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message message) {
					try {
						ObjectMessage m =(ObjectMessage)message;
						Object bean =m.getObject();
						if (null != message) {
							System.out.println("收到消息" + ((MqBean) bean).getName());
						}
//						message.acknowledge();
//						session.commit();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
