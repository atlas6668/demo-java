package com.atlas.java.asm;

/**
 * 自定义ClassLoader
 * @author sunwenming
 * @date 2019/1/16.
 */
public class MyClassLoader extends ClassLoader {

    public MyClassLoader(){
        super(Thread.currentThread().getContextClassLoader());
    }

    public Class<?> defineClass(String name, byte[] bytes){
        return this.defineClass(name, bytes, 0, bytes.length);
    }

}
