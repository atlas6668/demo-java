package com.atlas.java.jvm.methodWorking;

/**
 * Created by sunwenming on 2018/8/6.
 */
public class FinalExample {

    int i;
    final int j;

    static FinalExample obj;

    public FinalExample(){
        i = 1;
        j = 2;
        // final域 StoreStore屏障 在这里
        // 确保构造函数return前 final域 j=2 完成

    }

    public static void write(){
        obj = new FinalExample();
    }

    public static void reader(){
        FinalExample object = obj;
        int a = object.i;
        // final域 LoadLoad屏障 在这里
        // 确保初次读对象包含的final域前 读对象引用完成
        int b = object.j;
    }

}
