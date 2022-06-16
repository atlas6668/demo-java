package com.atlas.spring.ioc;


import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sunwenming
 * @date 2022/6/14.
 */
@Service
@Scope("singleton")
public abstract class IndexService方法注入 {


    @Lookup("indexDaoImpl注解注入")
    protected abstract IndexDao getIndexDaoImpl注解注入();

    @Resource
    private IndexDao dao0;


    public void service() {
        System.out.println("indexDaoImpl注解注入:"+getIndexDaoImpl注解注入().hashCode());
        System.out.println("dao0:"+dao0.hashCode());
    }

}
