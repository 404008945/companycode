package com.mybatis.cache.mybatiscache;

import com.github.pagehelper.PageHelper;
import com.mybatis.cache.mybatiscache.entity.UserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Properties;

@Configuration
public class MyConfiguration {

  //  @Bean
        public  PageHelper PageHelperpageHelper(){
            System.out.println("MybatisConfiguration.pageHelper()");
            PageHelper pageHelper =new PageHelper();
            Properties properties =new Properties();
            properties.setProperty("offsetAsPageNum","true");
            properties.setProperty("rowBoundsWithCount","true");
            properties.setProperty("reasonable","true");
            pageHelper.setProperties(properties);
            return pageHelper;
        }

    @Autowired
    public void addMySqlInterceptor( List<SqlSessionFactory> sqlSessionFactoryList) {
        MySqlInterceptor interceptor = new MySqlInterceptor();
        for (SqlSessionFactory sqlSessionFactory : sqlSessionFactoryList) {

            // 添加自定义属性
//            Properties properties = new Properties();
//            properties.setProperty("prop1", "value1");
//            interceptor.setProperties(properties);
            sqlSessionFactory.getConfiguration().addInterceptor(interceptor);

        }
    }
}
