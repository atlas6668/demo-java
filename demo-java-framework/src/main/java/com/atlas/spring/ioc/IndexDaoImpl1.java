package com.atlas.spring.ioc;

/**
 * @author sunwenming
 * @date 2022/6/14.
 */
public class IndexDaoImpl1 implements IndexDao {
    @Override
    public void query() {
        System.out.println("impl1");
    }
}
