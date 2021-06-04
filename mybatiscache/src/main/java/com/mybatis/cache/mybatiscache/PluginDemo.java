package com.mybatis.cache.mybatiscache;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.Properties;

public class PluginDemo implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        /**
         * 获取被拦截的目前类，在这里是拦截了statementHandler，所有目前类也就是它
         * 通过这个类我们可以拿到待执行的sql语句，通常使用mataObject工具类来获取
         * 关于这个工具类，大家可自行了解，个人认为这个工具类很强大
         */
        MappedStatement statementHandler = (MappedStatement) invocation.getTarget();
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        /**
         * 先解释下为什么写成delegate.boundSql就可以拿到boundSql类
         * 从前面也可以得知，statementHandler的默认实现是routingStatementHandler。
         * 这个类有一个属性statementHandler，属性名就叫delegate，而这个属性的默认实现又是preparedStatementHandler
         * 后面这个类又有属性boundSql，所以，最终形成的写法就是delegate.boundSql。
         * 所以这也体现了MetaObject工具类的强大，可以通过实例传参，就可以根据属性名获取对应属性值
         */
        BoundSql boundSql = (BoundSql) metaObject.getValue("delegate.boundSql");

        // 待执行的sql，在这里也就是预编译后的sql，即参数位都是?号
        String sql = boundSql.getSql();
        /**
         * 既然拿到了预编译后的sql，那就可以按照你自己的想法为所欲为，如分页，按年分表等等
         * 分表的话，个人推荐druid的sql解析器，我认为还是不错的，大家可以自行了解
         * 最后改造完sql，别忘了把它设置回去
         * metaObject.setValue("delegate.boundSql.sql",sql);
         *  invocation.proceed，即原始方法的执行
         *  注意点就是，因为mybatis插件采用的是代理模式，所以如果存在多个插件，会形成多个代理
         *  你如果要拿到最原始的对象，还得进一步进行分解
         *  如：while(metaObject.getValue(""h) != null){
         *      Object obj = metaObject.getValue("h");
         *       ....
         *  }
         */
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}