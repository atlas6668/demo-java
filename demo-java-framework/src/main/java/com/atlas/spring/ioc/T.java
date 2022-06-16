package com.atlas.spring.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sunwenming
 * @date 2022/6/14.
 */
public class T {

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext
//                = new ClassPathXmlApplicationContext("classpath:ioc/spring-手动装配.xml");
//        IndexService手动装配 indexService手动装配 = (IndexService手动装配) classPathXmlApplicationContext.getBean("service");
//        indexService手动装配.service();

//        ClassPathXmlApplicationContext classPathXmlApplicationContext
//                = new ClassPathXmlApplicationContext("classpath:ioc/spring-自动装配.xml");
//        IndexService自动装配 indexService自动装配 = (IndexService自动装配) classPathXmlApplicationContext.getBean("service");
//        indexService自动装配.service();

        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(Spring.class);
        IndexService混合注入 indexService混合注入 = annotationConfigApplicationContext.getBean(IndexService混合注入.class);
        indexService混合注入.service();

//        IndexService方法注入 indexServiceScope0 = annotationConfigApplicationContext.getBean(IndexService方法注入.class);
//        System.out.println("indexServiceScope0:"+indexServiceScope0.hashCode());
//        indexServiceScope0.service();
//        IndexService方法注入 indexServiceScope1 = annotationConfigApplicationContext.getBean(IndexService方法注入.class);
//        System.out.println("indexServiceScope1:"+indexServiceScope1.hashCode());
//        indexServiceScope1.service();

    }
}
