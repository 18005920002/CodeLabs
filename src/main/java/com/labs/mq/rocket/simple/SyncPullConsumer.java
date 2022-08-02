package com.labs.mq.rocket.simple;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 消息消费
 * @Author: tanyun.zheng
 * @Date: 2019/10/17 17:19
 */
public class SyncPullConsumer {

    private static Map<MessageQueue, Long> offsetTable = new HashMap<MessageQueue, Long>();

    public static void main(String[] args) throws Exception {

        final String groupName = "RMQ-G-01";
        final String topic = "Topic-01";


        DefaultMQPullConsumer consumer = new DefaultMQPullConsumer(groupName);
        consumer.setNamesrvAddr("10.112.169.34:9876");
        consumer.start();
        System.out.printf("Consumer Started.%n");

        Set<MessageQueue> mqs = consumer.fetchSubscribeMessageQueues(topic);
        for (MessageQueue mq : mqs) {
            System.out.printf("Consume from the queue:%s%n", mq);
            SINGLE_MQ:
            while (true) {
                PullResult pullResult = consumer.pullBlockIfNotFound(mq, null, getMessageQueueOffset(mq), 32);
                System.out.printf("%s,%n", pullResult);

                putMessageQueueOffset(mq, pullResult.getNextBeginOffset());
                switch ((pullResult.getPullStatus())) {
                    case FOUND:
                        break;
                    case NO_MATCHED_MSG:
                        break;
                    case NO_NEW_MSG:
                        break SINGLE_MQ;
                    case OFFSET_ILLEGAL:
                        break;
                }
            }
        }

    }

    private static long getMessageQueueOffset(MessageQueue mq) {
        Long offset = offsetTable.get(mq);
        if (offset != null)
            return offset;

        return 0;
    }

    private static void putMessageQueueOffset(MessageQueue mq, long offset) {
        offsetTable.put(mq, offset);
    }
}
