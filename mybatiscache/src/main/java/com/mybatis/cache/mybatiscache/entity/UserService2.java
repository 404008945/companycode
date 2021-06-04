package com.mybatis.cache.mybatiscache.entity;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.Thread.sleep;

@Service
public class UserService2 {


    @Autowired
    private UserMapper userMapper;



    public void update() throws InterruptedException { //更新
        sleep(1000);
        userMapper.update();
    }

    public void se1() throws InterruptedException { //更新
      //  PageHelper.startPage(1,10);
        ResultHandler handler = new MyExport();
        List<User> users = userMapper.selById(1,handler);
     //   PageInfo<User> pageInfo = new PageInfo(users);
        userMapper.update();
        List<User> users1 = userMapper.selById(1,handler);
        userMapper.Sel1();
        System.out.println("执行结束1");

    }

    public void sel1() throws InterruptedException {
        System.out.println(userMapper.Sel1());
        System.out.println("执行结束2");
    }
}
