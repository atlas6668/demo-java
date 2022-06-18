package com.atlas.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author sunwenming
 * @date 2022/6/17.
 */
@Configuration
@ComponentScan("com.atlas.spring.aop")
/**
 * proxyTargetClass = false 默认spring 使用jdk proxy
 * = true 使用 CGLIB proxy
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
