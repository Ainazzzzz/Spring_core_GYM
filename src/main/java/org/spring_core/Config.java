package org.spring_core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.spring_core")
@PropertySource(value = "classpath:application.properties")
public class Config {
}
