package com.atlas.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author sunwenming
 * @date 2022/6/17.
 */
@Component
@Aspect
public class AtlasAspectJ {

    /**
     * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
     * execution(方法的修饰符? 方法的返回类型 方法的声明类全路径名?方法名(参数类型) 抛出异常类型?)
     * 跟？表示可选
     *
     */
    @Pointcut("execution(* com.atlas.spring.aop.*.*(..))")
    public void pointCutExecution() {

    }

    /**
     * 只能限定到具体类
     */
    @Pointcut("within(com.atlas.spring.aop.*)")
    public void pointCutWithin() {

    }

    @Pointcut("args(java.lang.String)")
    public void pointArgs() {

    }

//    @Before("pointCutWithin() && !pointArgs()")
//    public void before() {
//        System.out.println("before");
//    }

    @Pointcut("this(com.atlas.spring.aop.IndexDaoImpl)")
    public void pointThis() {

    }

    @Pointcut("target(com.atlas.spring.aop.IndexDaoImpl)")
    public void pointTarget() {

    }

    /**
     * @target @args @within @annotation
     * 区别 target args within 在于 方法被加了注解
     */
    @Pointcut("@annotation(com.atlas.spring.aop.Atlas)")
    public void pointAnnotation() {

    }

    @Before("pointAnnotation()")
    public void before() {
        System.out.println("before");
    }

//    @After("pointCutExecution()")
//    public void after() {
//        System.out.println("after");
//    }

}
