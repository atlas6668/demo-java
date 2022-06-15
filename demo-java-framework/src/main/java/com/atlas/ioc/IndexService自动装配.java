package com.atlas.ioc;


/**
 * @author sunwenming
 * @date 2022/6/14.
 */
public class IndexService自动装配 {


    /**
     * byType方式 注入不依赖setter名称
     * byName方式 注入依赖setter名称
     */
    public void setDao1(IndexDao dao) {
        this.Dao0 = dao;
    }

    private IndexDao Dao0;

    public void service() {
        Dao0.query();
    }

}
