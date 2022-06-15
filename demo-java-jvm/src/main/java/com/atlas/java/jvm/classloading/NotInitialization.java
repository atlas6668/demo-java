package com.atlas.java.jvm.classloading;

/**
 * @author sunwenming
 * @date 2019/1/11.
 */

public class NotInitialization {

    public static void main(String[] args) {
        System.out.println(SubClass.value);

//        System.out.println(SubClass.intVal);

//        newInstance();

//        System.out.println(ConstClass.HELLOWORLD);
    }


    /**
     * 这里有一则结论
     */

    /**
     * 通过数组定义来引用类，不会触发类的初始化
     */

    private static void newInstance(){
        SuperClass[] sca = new SuperClass[2];
    }

}

/**
 * 这里有一则结论
 */

/**
 * 通过子类引用父类定义的静态字段，只会触发父类的初始化而不会触发子类的初始化。
 */

class SuperClass {

    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;

}

/**
 * 这里有一则结论
 */

/**
 * 运行时，对于静态字段，只有直接定义这个字段的类才会被初始化；
 */

class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init!");
    }

    public static int intVal = 456;

}

/**
 * 这里有一则结论
 */

/**
 * 常量在编译阶段会存入调用类的常量池（常量传播优化），本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化。
 */

class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD = "hello world";

}
