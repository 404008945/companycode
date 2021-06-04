package com.mybatis.cache.mybatiscache.entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class UserService {

    @Autowired
    private UserService1 userService1;
    private String name;
    @Async
    public void hello(){
        System.out.println("hello");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
