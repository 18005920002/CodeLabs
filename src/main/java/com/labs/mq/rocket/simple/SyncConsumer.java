package com.labs.mq.rocket.simple;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @Description: 消息消费
 * @Author: tanyun.zheng
 * @Date: 2019/10/17 17:19
 */
public class SyncConsumer {
    public static void main(String[] args) {
        //final String groupName = "RMQ-G-01";
        //final String topic = "Topic-01";

        final String groupName = "RMQ-G-01";
        final String topic = "Topic-01";

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);
        try{
            consumer.setNamesrvAddr("10.112.169.34:9876");
            consumer.subscribe(topic,"*");
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                    System.out.printf("%s Receive New Message:[ %s ]\n",Thread.currentThread().getName(),msgs);
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            consumer.start();
            System.out.printf("Consumer Started.%n");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
