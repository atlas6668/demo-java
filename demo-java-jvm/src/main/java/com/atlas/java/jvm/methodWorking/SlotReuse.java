package com.atlas.java.jvm.methodWorking;

/**
 * Created by sunwenming on 2018/6/19.
 * 局部变量表slot槽复用问题
 */
public class SlotReuse {

    public static void methodA(){
        byte[] placeholder = new byte[64 * 1024 * 1024];
        System.gc();
    }

    public static void methodB(){
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        System.gc();
    }

    public static void methodC(){
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }

    public static void main(String[] args) {
//        methodA();

//        methodB();

//        methodC();

    }

}
