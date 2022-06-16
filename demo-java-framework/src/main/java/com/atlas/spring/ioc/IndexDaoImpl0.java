package com.atlas.spring.ioc;


/**
 * @author sunwenming
 * @date 2022/6/14.
 */
public class IndexDaoImpl0 implements IndexDao {

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    private String sourceName;


    @Override
    public void query() {
        System.out.println("impl0");
        System.out.println("sourceName:"+sourceName);
    }
}
