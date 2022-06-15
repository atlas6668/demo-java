package com.atlas.java.jvm.methodWorking;

import java.io.Serializable;

/**
 * Created by sunwenming on 2018/6/20.
 * 静态分派（所有依赖静态类型来定位方法执行版本的分派动作）
 * 分派时机：编译阶段
 * 典型应用：方法重载
 */
public class StaticDispatch {

    public static void sayHello(short arg){
        System.out.println("hello short");
    }

    public static void sayHello(byte arg){
        System.out.println("hello byte");
    }

    public static void sayHello(Object arg){
        System.out.println("hello Object");
    }

//    public static void sayHello(int arg){
//        System.out.println("hello int");
//    }

    public static void sayHello(long arg){
        System.out.println("hello long");
    }

//    public static void sayHello(char arg){
//        System.out.println("hello char");
//    }

    public static void sayHello(float arg){
        System.out.println("hello float");
    }

    public static void sayHello(double arg){
        System.out.println("hello double");
    }

    public static void sayHello(char... args){
        System.out.println("hello char...");
    }

    public static void sayHello(Serializable arg){
        System.out.println("hello Serializable");
    }

    public static void main(String[] args) {
        sayHello('a');
    }

}
