package com.labs.mq.rocket.simple;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @Description: 同步发送
 * @Author: tanyun.zheng
 * @Date: 2019/10/17 11:18
 */
public class SyncProducer {

    public static void main(String[] args) {

        final String groupName = "RMQ-G-01";
        final String topic = "Topic-01";
        final String tag = "Tag-01";
        DefaultMQProducer producer = new DefaultMQProducer(groupName);
        producer.setNamesrvAddr("10.112.169.34:9876");
        try {
            producer.start();
            for (int i = 0; i < 1000; i++) {
                String content = "Hello,Message-" + i;
                Message msg = new Message(topic, tag, content.getBytes());
                SendResult sendResult = producer.send(msg);
                System.out.println(sendResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            producer.shutdown();
        }
    }
}
