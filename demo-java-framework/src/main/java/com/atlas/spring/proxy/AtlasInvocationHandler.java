package com.atlas.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author sunwenming
 * @date 2022/7/19.
 */
public class AtlasInvocationHandler implements InvocationHandler {

    Object target;

    public AtlasInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("AtlasInvocationHandler jdk proxy ");
        return method.invoke(target, args);
    }
}
