package com.atlas.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author sunwenming
 * @date 2022/6/17.
 */
public class T {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        IndexDao indexDao = annotationConfigApplicationContext.getBean(IndexDao.class);
        System.out.println(indexDao instanceof IndexDaoImpl);
        indexDao.query();
        indexDao.query("select ****** ");
    }

}
