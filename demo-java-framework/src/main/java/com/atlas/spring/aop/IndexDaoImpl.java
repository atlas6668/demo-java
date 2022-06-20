package com.atlas.spring.aop;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @author sunwenming
 * @date 2022/6/17.
 */
@Repository("dao")
//@Scope("prototype")
public class IndexDaoImpl implements IndexDao {

    public IndexDaoImpl() {
        System.out.println("Constructor:" + this.hashCode());
    }

    @Override
    public void query() {
        System.out.println("query0:" + this.hashCode());
    }

    @Atlas
    @Override
    public void query(String sql) {
        System.out.println("query1:" + this.hashCode());
    }
}
