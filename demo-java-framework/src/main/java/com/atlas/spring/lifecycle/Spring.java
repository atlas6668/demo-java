package com.atlas.spring.lifecycle;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author sunwenming
 * @date 2022/6/16.
 */
@Configuration
@ComponentScan(value = "com.atlas.spring.lifecycle")
@ImportResource("classpath:lifecycle/spring.xml")
public class Spring {
}
