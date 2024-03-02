package com.cydeo.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigApp {

    @Bean
    FullTimeMentor fullTimeMentor(){
        return new FullTimeMentor();
    }

    @Primary
    PartTimeMentor partTimeMentor1(){
        return new PartTimeMentor();
    }
    @Primary
    @Bean(name = "p2")
    PartTimeMentor partTimeMentor2(){
        return new PartTimeMentor();
    }

    @Bean(name = "p3")
    PartTimeMentor partTimeMentor3(){
        return new PartTimeMentor();
    }

}
