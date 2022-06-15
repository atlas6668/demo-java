package com.atlas.java.asm;



/**
 * @author sunwenming
 * @date 2019/1/18.
 */
public class T {

    public static void method0(){
        long totalCount = 44434;
        int size = 200;
        for(int from = 0; from < totalCount; from += size){
            System.out.println("invoke : from-" + from + " size-" + size);
        }
    }

    public static void main(String[] args) {

    }

}
