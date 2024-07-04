package com.cydeo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
/*
    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))")
    private void pointcut(){
    }

    @Before(("pointcut()"))
    public void log(){
        logger.info("Logger info...");
    }

    @Before("execution(* com.cydeo.controller.CourseController.*(..))")
    public void beforeAdvice(){
        logger.info("Logger info...");
    }

 */

    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))")
    private void anyProductRepositoryFindById(){}

    @Before("anyProductRepositoryFindById()")
    public void beforeCourseRepoAdvice(JoinPoint joinPoint){
        logger.info("Before (findById) -> Method {} : Arguments : {} Target : {} -> " , joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }









}
