package com.mybatis.cache.mybatiscache.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class UserService1 {

    @Autowired
    private UserService userService;

    @Async
    public void hello(){
        System.out.println("hello");
    }
}
