package com.atlas.spring.aop;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author sunwenming
 * @date 2022/6/18.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Atlas {

    String value() default "";

}
