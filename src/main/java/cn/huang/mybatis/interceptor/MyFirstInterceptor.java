package cn.huang.mybatis.interceptor;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.Properties;

/**
 * @Author: Yaking
 * @Date: 2019-07-14 10:48
 * @Describe: 插件签名：告诉mybatis当前插件用来拦截哪个对象的哪个方法
 */
@Intercepts({@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = Statement.class)})
public class MyFirstInterceptor implements Interceptor {
    //拦截目标对象的目标方法的
    public Object intercept(Invocation invocation) throws Throwable {
        //获取当前拦截的目标对象
        System.out.println("拦截的目标对象" + invocation.getTarget());
        Object object = invocation.proceed();
        return object;
    }

    //包装目标对象，为目标对象创建代理对象
    public Object plugin(Object o) {
        System.out.println("将要包装的对象" + o);
        return Plugin.wrap(o, this);
    }

    //初始化插件的参数
    public void setProperties(Properties properties) {
        System.out.println("插件配置的初始化参数" + properties);
    }
}
