package com.mybatis.cache.mybatiscache.entity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:wjup
 * @Date: 2018/9/26 0026
 * @Time: 15:20
 */
@Repository
public interface UserMapper2 {

    List<User> Sel();

    List<User> Sel1();

     int update();
}