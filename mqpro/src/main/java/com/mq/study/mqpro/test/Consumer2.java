package com.mq.study.mqpro.test;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class Consumer2 {

    public static void main(String[] args) throws MQClientException {
        // Instantiate with specified consumer group name.
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("mq-group");
        // Specify name server addresses.
        consumer.setNamesrvAddr("127.0.0.1:9876");
        // Subscribe one more more topics to consume.
        consumer.subscribe("TopicA-test24", "*");
        // Register callback to execute on arrival of messages fetched from brokers.
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
                MessageExt messageExt = msgs.get(0);
                try {
                    byte[] body = messageExt.getBody();
                    String tags = messageExt.getTags();
                    String topic = messageExt.getTopic();
                    String keys = messageExt.getKeys();
                    System.out.println("body:"+new String(body, RemotingHelper.DEFAULT_CHARSET)+" tags:"+tags+" topic:"+topic+" keys:"+keys);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    //处理出现异常，获取重试次数.达到某个次数的时候可以记录日志，做补偿处理
                    int reconsumeTimes = messageExt.getReconsumeTimes();
                    if(reconsumeTimes == 3){
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    }

                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //Launch the consumer instance.
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }
}