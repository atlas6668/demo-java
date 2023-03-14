package com.atlas.spring.proxy;

import org.springframework.stereotype.Repository;

/**
 * @author sunwenming
 * @date 2022/7/19.
 */
@Repository
public class IndexDaoImpl implements IndexDao {
    @Override
    public void query() {
        System.out.println("query ... ");
    }
}
