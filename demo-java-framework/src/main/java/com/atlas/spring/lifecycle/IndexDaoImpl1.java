package com.atlas.spring.lifecycle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author sunwenming
 * @date 2022/6/16.
 */
@Repository
@Profile("dao1")
public class IndexDaoImpl1 implements IndexDao, InitializingBean {

    public IndexDaoImpl1() {
        System.out.println("Constructor 1");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("init 1");
    }
}
