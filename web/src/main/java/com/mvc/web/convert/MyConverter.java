package com.mvc.web.convert;



import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        System.out.println("转换了没？");

        return new Date();
    }
// 参数是源类型（要转换的字符串），返回的是目标类型
}