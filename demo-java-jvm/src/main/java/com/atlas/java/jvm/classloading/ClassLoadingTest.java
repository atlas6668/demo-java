package com.atlas.java.jvm.classloading;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author sunwenming
 * @date 2019/1/11.
 */
public class ClassLoadingTest {

    public static void main(String[] args) throws Exception {
        ClassLoadingTest.aMethod();
    }

    /**
     * 这里有一则结论
     */

    /**
     * 即使两个类来源于同一个Class文件，被同一个虚拟机加载，只要加载它们的类加载器不同，那这两个类就必定不相等。
     *
     * 通俗意义上比较两个类是否"相等"，只有在这两个类是由同一个类加载器加载的前提下才有意义。
     */

    public static void aMethod() throws Exception {
        ClassLoader  myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(is == null){
                        return super.loadClass(name);
                    }
                    byte[] bytes = new byte[is.available()];
                    is.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e){
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object obj = myLoader.loadClass("com.atlas.java.jvm.classloading.ClassLoadingTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoadingTest);
        ClassLoadingTest t = new ClassLoadingTest();
        System.out.println(t instanceof ClassLoadingTest);
    }

}
