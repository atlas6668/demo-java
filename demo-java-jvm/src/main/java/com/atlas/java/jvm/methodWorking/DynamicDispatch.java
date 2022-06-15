package com.atlas.java.jvm.methodWorking;

/**
 * Created by sunwenming on 2018/6/20.
 * 动态分派（运行期根据实际类型确定方法执行版本的分派动作）
 * 分派时机：运行阶段
 * 典型应用：方法重写
 */
public class DynamicDispatch {

    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {

        @Override
        protected void sayHello() {
            System.out.println("man say hello");
        }
    }

    static class Woman extends Human {

        @Override
        protected void sayHello() {
            System.out.println("woman say hello");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }

}
