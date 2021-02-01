package com.aop.aopstudy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect2 {
    @Autowired
    private LogAspect logAspect;

    @Before("execution(public * com.aop.aopstudy.test.UserService.sayHello(..))")
    public void before(){
        System.out.println("------------------hello 方法执行前-------------------");
    }

    @After("execution(public * com.aop.aopstudy.test.UserService.sayHello(..))")
    public void after(){
        System.out.println("------------------hello 方法执行后-------------------");
    }
}