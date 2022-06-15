package com.atlas.java.asm;

import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * @author sunwenming
 * @date 2019/1/21.
 */
public class MyClassLoader0 extends ClassLoader {

    private String classPath;

    public MyClassLoader0(String classPath) {
        this.classPath = classPath;
    }

    private byte[] loadByte(String name) throws Exception {
        name = name.replaceAll("\\.", "/");
        FileInputStream fis = new FileInputStream(classPath + "/" + name
                + ".class");
        int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);
        fis.close();
        return data;

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadByte(name);
            return defineClass(name, data, 0, data.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }

    public static void main(String args[]) throws Exception {
        MyClassLoader0 classLoader = new MyClassLoader0("/Users/sunwenming/ideaspace/demo-java-parent/demo-java-jvm/target/classes");
        Class clazz = classLoader.loadClass("com.atlas.java.jvm.methodWorking.StaticResolution");
        Object obj = clazz.newInstance();
        Method helloMethod = clazz.getDeclaredMethod("sayHello", null);
        helloMethod.invoke(obj, null);
    }

}
