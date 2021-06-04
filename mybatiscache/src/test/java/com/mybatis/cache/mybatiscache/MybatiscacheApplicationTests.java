package com.mybatis.cache.mybatiscache;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.cache.mybatiscache.entity.MyBean;
import com.mybatis.cache.mybatiscache.entity.User;
import com.mybatis.cache.mybatiscache.entity.UserMapper;
import com.mybatis.cache.mybatiscache.entity.UserService2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class MybatiscacheApplicationTests {
    private InputStream in ;
    private SqlSessionFactory factory;
    private SqlSession session;
    @Autowired
    private SqlSessionFactory  sqlSessionFactory;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService2 userService2;

    @Test
    void contextLoads()  throws Exception{

      PageHelper.startPage(1,1);//利用了mybatis的拦截器
      List<User> users = userMapper.Sel();//何时生成的代理
      PageInfo pageInfo = new PageInfo(users);
      System.out.println(pageInfo);

    }

    @Test
    void test1(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(()->{
            try {
                userService2.se1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(()->{
            try {
                userService2.update();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        while (true);
    }

    @Test
    void test2(){
        try {
            userService2.se1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Autowired
    private MyBean myBean;
    @Test
    void test3(){
        System.out.println("myBean2 = " + myBean.getMessage());

    }




}
