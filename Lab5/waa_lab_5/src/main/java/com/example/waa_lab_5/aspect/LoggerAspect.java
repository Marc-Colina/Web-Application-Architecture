package com.example.waa_lab_5.aspect;

import com.example.waa_lab_5.entity.Logger;
import com.example.waa_lab_5.service.spec.ILoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class LoggerAspect {
    ILoggerService iLoggerService;

    public LoggerAspect(ILoggerService iLoggerService) {
        this.iLoggerService = iLoggerService;
    }

    @Pointcut("execution(* com.example.waa_lab_5.controller..*(..))")
    public void saveLogsInControllerMethods() {
    }

    @Before("saveLogsInControllerMethods()")
    public void saveLogs(JoinPoint jointPoint) {

        Logger logger = new Logger();
        logger.setDate(LocalDate.now());
        logger.setTime(LocalTime.now());
        logger.setPrinciple("Fake User");
        logger.setOperation(jointPoint.getSignature().getName());

        iLoggerService.save(logger);
    }
}
