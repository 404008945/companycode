package com.aop.aopstudy;

import com.aop.aopstudy.test.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AopstudyApplicationTests {

    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        userService.sayHello();
    }

}
