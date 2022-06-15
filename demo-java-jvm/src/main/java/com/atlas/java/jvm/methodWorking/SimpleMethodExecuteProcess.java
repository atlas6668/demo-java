package com.atlas.java.jvm.methodWorking;

/**
 * Created by sunwenming on 2018/6/19.
 * 简单的方法执行过程
 */
public class SimpleMethodExecuteProcess {

    static int i = 0;

    /**
     * 运算指令
     * @param a
     * @param b
     * @return
     */
    public static int methodA(int a, int b){
        return a + b;
    }

    public static int methodB(int a, int b){
        return a - b;
    }

    public static int methodC(int a, int b){
        return a * b;
    }

    public static void methodD(){
        System.out.println(Thread.currentThread());
    }

    /**
     * Byte    范围 bipush
     * Short   范围 sipush
     * Integer 范围 sipush
     * @return
     */
    public static int methodE(){
        int e = 100;
        int c = 300;
        int d = 300000;
        e++;
        ++e;
        --e;
        e--;
        return c + d + e;
    }

    /**
     * double 型 返回
     * @return
     */
    public static double methodF(){
        return 1.0d;
    }

    /**
     * 控制转移指令
     */
    public static void methodG(){
        if(i == 0){
            System.out.println(System.currentTimeMillis());
        }

        while(i < 1){
            System.out.println(System.currentTimeMillis());
            i++;
        }
    }

    /**
     * 异常处理指令
     */
    public static void methodH(){
        try {
            throw new NullPointerException("nothing ...");
            // do nothing ...
        } catch (Throwable t){
            // do nothing ...
        }
    }

    /**
     * 同步指令 monitor（管程）
     */
    public void methodI(){
        synchronized (Integer.class){
            // do nothing ...
        }
    }

    /**
     * 对象创建与访问指令
     */
    public static void methodJ(){
        new SimpleMethodExecuteProcess();

        System.out.println(SimpleMethodExecuteProcess.i);
    }

    /**
     * 类型转换指令
     */
    public static void methodK(){
        int i = 97;
        short i2s = (short) i;
        char i2c = (char) i;
        long i2l = i;
        float i2f = i;
        double i2d = i;
        float l2f = i2l;
        double l2d = i2l;
    }

    /**
     * synchronized 修饰方法 语义
     */
    public static synchronized void methodL(){
        int i = 97;
    }

    /**
     * 加载、存储指令
     * @return
     */
    public static int heavyMethod(){
        int a = 200;
        int b = 100;
        int c = methodC(methodA(a, b), methodB(a, b));
        methodD();
        methodE();
        methodF();
        methodG();
        methodH();
        new SimpleMethodExecuteProcess().methodI();
        methodJ();
        methodK();
        methodL();
        return c;
    }

    public static void main(String[] args) {
        heavyMethod();
    }

}
