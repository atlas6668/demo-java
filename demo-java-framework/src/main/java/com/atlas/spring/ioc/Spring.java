package com.atlas.spring.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author sunwenming
 * @date 2022/6/14.
 */
@Configuration
@ComponentScan(value = "com.atlas.spring.ioc")
@ImportResource("classpath:ioc/spring-混合注入.xml")
public class Spring {
}
