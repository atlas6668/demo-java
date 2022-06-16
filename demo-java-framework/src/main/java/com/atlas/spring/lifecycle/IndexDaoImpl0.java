package com.atlas.spring.lifecycle;

/**
 * @author sunwenming
 * @date 2022/6/16.
 */
public class IndexDaoImpl0 implements IndexDao {

    public IndexDaoImpl0() {
        System.out.println("Constructor 0");
    }

    public void init() {
        System.out.println("init 0");
    }

}
