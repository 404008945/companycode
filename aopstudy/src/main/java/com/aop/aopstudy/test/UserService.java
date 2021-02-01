package com.aop.aopstudy.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//无循环依赖
@Component

@Transactional
public class UserService {
    @Autowired
    private UserServiceB userServiceB;
    public UserService(){
        System.out.println("初始化");
    }

    public void sayHello(){
        System.out.println("hello");
    }

    public UserServiceB getUserServiceB() {
        return userServiceB;
    }

    public void setUserServiceB(UserServiceB userServiceB) {
        this.userServiceB = userServiceB;
    }
}
