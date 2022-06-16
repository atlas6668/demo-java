package com.atlas.spring.lifecycle;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * @author sunwenming
 * @date 2022/6/16.
 */
@Repository
@Profile("dao2")
public class IndexDaoImpl2 implements IndexDao {

    public IndexDaoImpl2() {
        System.out.println("Constructor 2");
    }

    @PostConstruct
    public void init() {
        System.out.println("init 2");
    }

}
