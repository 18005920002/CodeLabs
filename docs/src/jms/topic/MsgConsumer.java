package com.labs.jdk5.jms.topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MsgConsumer {
    //tcp://localhost:61616
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BORKEURL = ActiveMQConnection.DEFAULT_BROKER_URL; //默认的连接地址
    private static final int SENDNUM = 10;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;// = new ActiveMQConnectionFactory(JMSProducer.USERNAME,JMSProducer.PASSWORD,JMSProducer.BORKEURL);
        Connection connection = null;
        Session session; //会话，支持事务
        Destination destination;
        MessageConsumer consumer;
        connectionFactory = new ActiveMQConnectionFactory(MsgConsumer.USERNAME, MsgConsumer.PASSWORD, MsgConsumer.BORKEURL);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//支持事务，自动确认
            destination = session.createTopic("TOPIC_FIRST");
            consumer = session.createConsumer(destination);
            //consumer.setMessageListener(new ListenerConumer());
            //Thread.sleep(10000);
            //sendMessage(session, messageProducer);
			/*while(true){
				TextMessage tm = (TextMessage)conMsgConsumer.javasumer.receive();
				if(null!=tm){
					System.out.println("收到消息："+tm.getText());
				}else{
					break;
				}
			}*/
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message arg0) {
                    try {
                        System.out.println("Consumer-1 Receive：" + ((TextMessage) arg0).getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread.sleep(20000);
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}