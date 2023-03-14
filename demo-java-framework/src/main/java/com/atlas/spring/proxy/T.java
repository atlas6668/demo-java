package com.atlas.spring.proxy;

import java.lang.reflect.Proxy;

/**
 * @author sunwenming
 * @date 2022/6/24.
 */
public class T {

    public static void main(String[] args) {
        IndexDao indexDao = (IndexDao) Proxy.newProxyInstance(T.class.getClassLoader(), new Class[]{IndexDao.class},
                new AtlasInvocationHandler(new IndexDaoImpl()));
        indexDao.query();
    }
}
