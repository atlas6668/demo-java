package com.atlas.ioc;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sunwenming
 * @date 2022/6/14.
 */
@Service
public class IndexService混合注入 {


    @Resource
    private IndexDao indexDaoImpl注解注入;

    @Resource
    private IndexDao dao0;


    public void service() {
        indexDaoImpl注解注入.query();
        dao0.query();
    }

}
