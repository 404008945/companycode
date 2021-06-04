package com.mybatis.cache.mybatiscache.entity;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

public class MyExport implements ResultHandler<Object> {

    @Override
    public void handleResult(ResultContext resultContext) {
        Object resultObject = resultContext.getResultObject();
        System.out.println(resultObject.toString());
        // TODO 在这里将每一条数据写入文件
    }
}
