package com.labs.jdk5.jms.p2p;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSProducer {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BORKEURL = ActiveMQConnection.DEFAULT_BROKER_URL; //默认的连接地址
    private static final int SENDNUM = 10;

    public static void main(String[] args) {

        ConnectionFactory connectionFactory;// = new ActiveMQConnectionFactory(JMSProducer.USERNAME,JMSProducer.PASSWORD,JMSProducer.BORKEURL);
        Connection connection = null;
        Session session; //会话，支持事务
        Destination destination;
        MessageProducer messageProducer;

        connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD, JMSProducer.BORKEURL);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);//支持事务，自动确认
            destination = session.createQueue("Queue_FIRST");
            messageProducer = session.createProducer(destination);
            sendMessage(session, messageProducer);
            session.commit();

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

    public static void sendMessage(Session session, MessageProducer producer) throws Exception {
        for (int i = 0; i < JMSProducer.SENDNUM; i++) {
            TextMessage tm = session.createTextMessage("ActiveMQ SEND " + i);
            System.out.println("发送消息：" + "ActiveMQ SEND " + i);
            producer.send(tm);
        }
    }
}
