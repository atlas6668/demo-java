package com.atlas.spring.aop;

import org.springframework.stereotype.Repository;

/**
 * @author sunwenming
 * @date 2022/6/17.
 */
@Repository("dao")
public class IndexDaoImpl implements IndexDao {

    public IndexDaoImpl() {
        System.out.println("Constructor");
    }

    @Override
    public void query() {
        System.out.println("query0");
    }

    @Atlas
    @Override
    public void query(String sql) {
        System.out.println("query1");
    }
}
