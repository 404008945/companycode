package com.mq.study.mqpro.test;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class ObjProduce {

    public static void main(String[] args) throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer("mq-group");
//        producer.setNamesrvAddr("123.207.63.192:9876");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.setInstanceName("producer");
        producer.start();
        MqData mqData = new MqData();

        try {
            for (int i = 0; i < 10; i++) {
                mqData.setData("I am message "+i);
                Thread.sleep(1000);  //MQ每隔一秒发送一条消息
                Message msg = new Message("TopicA-test241",// topic
                        "TagA",// tag
                        JSON.toJSONString(mqData)
                                .getBytes()// body
                );
                msg.setKeys("i"+i);
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
                producer.send(msg,10000000);
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