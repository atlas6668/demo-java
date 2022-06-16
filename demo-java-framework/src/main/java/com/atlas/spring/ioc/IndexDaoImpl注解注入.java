package com.atlas.spring.ioc;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @author sunwenming
 * @date 2022/6/14.
 */
@Repository
@Scope("prototype")
public class IndexDaoImpl注解注入 implements IndexDao {

    @Override
    public void query() {
        System.out.println("impl注解注入");
    }

}
