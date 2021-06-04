package com.study.quartz.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduler {

    //每隔五秒
    @Scheduled(cron = "0 31 * * * ? ")
    public void process(){

        System.out.println("向你发脏数据！");


    }
}