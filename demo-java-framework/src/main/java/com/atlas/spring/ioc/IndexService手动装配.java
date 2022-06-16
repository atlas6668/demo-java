package com.atlas.spring.ioc;


/**
 * @author sunwenming
 * @date 2022/6/14.
 */
public class IndexService手动装配 {


    private IndexDao dao;

    /**
     * setter方式依赖注入
     */
    public void setDao(IndexDao dao) {
        this.dao = dao;
    }

    /**
     * 构造方式依赖注入
     */
//    public IndexServiceA(IndexDao dao) {
//        this.dao = dao;
//    }

    public void service() {
        dao.query();
    }

}
