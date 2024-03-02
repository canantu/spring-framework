package com.cydeo.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigAny {

    // creating beans from String and Integer WrapperClasses
    @Bean
    String str(){
        return "Developer";
    }

    @Bean
    Integer number(){
        return 100;
    }
}
