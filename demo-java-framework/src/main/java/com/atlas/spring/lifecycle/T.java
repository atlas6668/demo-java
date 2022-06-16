package com.atlas.spring.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author sunwenming
 * @date 2022/6/16.
 */
public class T {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles("dao0");
        annotationConfigApplicationContext.register(Spring.class);
        annotationConfigApplicationContext.refresh();
    }

}
