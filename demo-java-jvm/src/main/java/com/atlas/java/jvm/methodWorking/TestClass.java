package com.atlas.java.jvm.methodWorking;

/**
 * Created by sunwenming on 2018/7/4.
 */
public class TestClass {

    private int m;

    private static int n = 1;

    public int inc(){
        System.out.println(this.getClass());
        return m + 1;
    }

    public static int sinc(){
        return n;
    }

    public void methodA(){
        m += 2;
    }

}
