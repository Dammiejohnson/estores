package com.catalyst.estores.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger myLogger = LoggerFactory.getLogger(getClass().getName());

    //setup pointcut declarations
    @Pointcut("execution(* com.catalyst.estores.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.catalyst.estores.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.catalyst.estores.repository.*.*(..))")
    private void forRepositoryPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forRepositoryPackage()")
    private void forAppFlow(){}

//    @Before("execution(* com.catalyst.estores.service.*.*(..))")
    @Before("forAppFlow()")
    public void logBefore(JoinPoint joinPoint) {
        myLogger.info("Before execution of: {}", joinPoint.getSignature());
    }

    @After("execution(* com.catalyst.estores.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        myLogger.info("After execution of: {}", joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution(* com.catalyst.estores.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        myLogger.info("Method {} returned: {}", joinPoint.getSignature(), result);
    }

    @AfterThrowing(pointcut = "execution(* com.catalyst.estores.service.*.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        myLogger.error("Exception in method {}: {}", joinPoint.getSignature().toShortString(), exception.getMessage());
    }
    
}
