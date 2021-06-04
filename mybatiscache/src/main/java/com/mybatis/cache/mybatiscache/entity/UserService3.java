package com.mybatis.cache.mybatiscache.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.Thread.sleep;

@Service
@Transactional
public class UserService3 {
    @Autowired
    private UserService2 userService2;

    @Autowired
    private UserMapper userMapper;

    public void update() throws InterruptedException { //更新
        sleep(1000);
        userMapper.update();
    }

    public void se1() throws InterruptedException { //更新
        System.out.println(userMapper.Sel());
        sleep(10000);
        System.out.println("执行结束1");

    }

    public void sel1() throws InterruptedException {
        sleep(1000);
        System.out.println(userMapper.Sel1());
        System.out.println("执行结束2");
    }
}
