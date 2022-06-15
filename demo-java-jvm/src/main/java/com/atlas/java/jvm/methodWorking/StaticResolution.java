package com.atlas.java.jvm.methodWorking;

/**
 * Created by sunwenming on 2018/6/20.
 * 静态解析（方法在程序真正运行之前就有一个可确定的调用版本，并且这个调用版本在运行期不可变）
 */
public class StaticResolution {

    public static void sayHello(){
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        sayHello();
    }
    /**
     *
         public static void main(java.lang.String[]);
             Signature: ([Ljava/lang/String;)V
             flags: ACC_PUBLIC, ACC_STATIC
             Code:
                 stack=0, locals=1, args_size=1
                 0: invokestatic  #5                  // Method sayHello:()V
                 3: return
             LineNumberTable:
                 line 14: 0
                 line 15: 3
     */

}
