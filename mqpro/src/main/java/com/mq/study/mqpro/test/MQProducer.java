package com.mq.study.mqpro.test;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.ArrayList;
import java.util.List;

//rocketMq默认同步发送就是局部有序的 ，加上一selector就是全局有序
public class MQProducer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer("mq-group");
//        producer.setNamesrvAddr("123.207.63.192:9876");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.setInstanceName("producer");
        producer.start();
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);  //MQ每隔一秒发送一条消息
                Message msg = new Message("TopicA-test24",// topic
                        "TagA",// tag
                        ("RocketMQ message"+i)
                                .getBytes()// body
                );
                msg.setKeys("i"+1);
//              producer.send(msg,new SendCallback() {//异步消息，发送消息交给线程池去做
//                    @Override
//                    public void onSuccess(SendResult sendResult) {
//                        System.out.printf("%s%n",sendResult);
//                    }
//                    @Override
//                    public void onException(Throwable throwable) {
//                        throwable.printStackTrace();
//                    }
//                },10000000);//发送消息
//                producer.sendOneway(msg);
                  producer.send(msg);
//                String topic = "BatchTest";
//                List<Message> messages = new ArrayList<>();
//                messages.add(new Message(topic, "TagA", "Order1", "Hello world 0".getBytes()));
//                messages.add(new Message(topic, "TagA", "Order2", "Hello world 1".getBytes()));
//                messages.add(new Message(topic, "TagA", "Order3", "Hello world 2".getBytes()));
//                producer.send(messages,10000000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.shutdown();//关闭消息生产者
    }
}
