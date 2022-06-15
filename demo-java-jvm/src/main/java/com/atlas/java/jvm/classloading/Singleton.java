package com.atlas.java.jvm.classloading;

/**
 * @author sunwenming
 * @date 2019/2/24.
 */
public class Singleton {

    private Singleton(){
        System.out.println("Singleton 已产生对象实例。");
    }

    private static class SingletonHolder {
        public static final Singleton singleton = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHolder.singleton;
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
        System.out.println(ActiveSingleton.getInstance());
    }

}

class ActiveSingleton {

    private static ActiveSingleton activeSingleton = new ActiveSingleton();

    private ActiveSingleton() {
        System.out.println("ActiveSingleton 已产生对象实例。");
    }

    public static ActiveSingleton getInstance() {
        return activeSingleton;
    }
}
