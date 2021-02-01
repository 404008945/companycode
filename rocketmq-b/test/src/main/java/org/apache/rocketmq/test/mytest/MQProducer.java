package org.apache.rocketmq.test.mytest;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

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
                Message msg = new Message("TopicA-test",// topic
                        "TagA",// tag
                        ("RocketMQ message"+i)
                                .getBytes()// body
                );
                SendResult sendResult = producer.send(msg);//发送消息
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.shutdown();//关闭消息生产者
    }
}
