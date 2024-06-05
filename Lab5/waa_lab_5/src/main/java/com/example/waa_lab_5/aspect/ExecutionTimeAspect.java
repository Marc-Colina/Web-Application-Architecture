package com.example.waa_lab_5.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Pointcut("@annotation(com.example.waa_lab_5.aspect.annotation.ExecutionTime)")
    public void logMethodsWithExecutionTimeAnnotation() {
    }

    @Around("logMethodsWithExecutionTimeAnnotation()")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();

        System.out.printf("Method %s executed in %d milliseconds", proceedingJoinPoint.getSignature().getName(),
                endTime - startTime);

        return proceed;
    }
}
