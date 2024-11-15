package com.catalyst.estores.aspect;


import com.catalyst.estores.annotations.ExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ExecutionTimeAspect {

    private final Logger myLogger = LoggerFactory.getLogger(getClass().getName());

    @Around("@annotation(executionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint, ExecutionTime executionTime) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        myLogger.info("Execution time of {}: {} ms", joinPoint.getSignature(), (end - start));
        return result;
    }

}
