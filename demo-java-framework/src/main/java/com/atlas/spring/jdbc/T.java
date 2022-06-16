package com.atlas.spring.jdbc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author sunwenming
 * @date 2022/6/16.
 */
public class T {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles("ok");
        annotationConfigApplicationContext.register(SpringConfig.class, SpringConfigFail.class);
        annotationConfigApplicationContext.refresh();
    }

}
