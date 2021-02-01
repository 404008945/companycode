package com.mq.study.mqpro.test;

import org.apache.rocketmq.client.consumer.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

public class ConsumerPullDemo {
    public static void main(String[] args) throws MQClientException {
        String groupName = "mq-group";
        String TOPIC_TEST = "TopicA-test24";
        final MQPullConsumerScheduleService scheduleService = new MQPullConsumerScheduleService(groupName);
        scheduleService.getDefaultMQPullConsumer().setNamesrvAddr("127.0.0.1:9876");
        scheduleService.setMessageModel(MessageModel.CLUSTERING);
        scheduleService.registerPullTaskCallback(TOPIC_TEST, new PullTaskCallback() {
            public void doPullTask(MessageQueue mq, PullTaskContext context) {
                MQPullConsumer consumer = context.getPullConsumer();
                try {
                    //获取从哪里开始拉取
                    long offset = consumer.fetchConsumeOffset(mq, false);
                    if(offset < 0) {
                        offset = 0;
                    }
                    PullResult pullResult = consumer.pull(mq, "*", offset, 32);
                    switch (pullResult.getPullStatus()) {
                        case FOUND:
                            List<MessageExt> list = pullResult.getMsgFoundList();
                            for (MessageExt msg : list) {
                                System.out.println(new String(msg.getBody()));
                            }
                            break;
                        case NO_MATCHED_MSG:
                            break;
                        case NO_NEW_MSG:
                        case OFFSET_ILLEGAL:
                            break;
                        default:
                            break;
                    }
                    //存储offset，客户端每隔5s会定时刷新到broker
                    consumer.updateConsumeOffset(mq, pullResult.getNextBeginOffset());
                    //重新拉取 建议超过5s这样就不会重复获取
                    context.setPullNextDelayTimeMillis(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        scheduleService.start();
    }
}
