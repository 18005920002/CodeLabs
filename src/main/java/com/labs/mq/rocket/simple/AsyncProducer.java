package com.labs.mq.rocket.simple;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 异步发送
 * @Author: tanyun.zheng
 * @Date: 2019/10/18 09:54
 */
public class AsyncProducer {

    private static Logger logger = LoggerFactory.getLogger(AsyncProducer.class);

    public static void main(String[] args) {

        final String groupName = "ASYNC_G02";
        final String topic = "ASYNC_T02";

        DefaultMQProducer producer = new DefaultMQProducer(groupName);
        producer.setNamesrvAddr("10.112.169.34:9876");
        try {
            producer.start();
            producer.setRetryTimesWhenSendAsyncFailed(0);
            for (int i = 0; i < 100; i++) {

                String msgText = "AN ASYNC MESSAGE";
                Message msg = new Message(topic, "ASYNC_TAG02", msgText.getBytes());
                producer.send(msg, new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        logger.info(JSON.toJSONString(sendResult));
                    }

                    @Override
                    public void onException(Throwable throwable) {
                        logger.error("Message Send Error：{}", throwable.getMessage(), throwable);
                    }
                });
            }
            Thread.sleep(3000);
            producer.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
