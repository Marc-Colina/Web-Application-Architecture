package com.example.waa_lab_7_back_end.aspect;

import com.example.waa_lab_7_back_end.entity.ExceptionEntity;
import com.example.waa_lab_7_back_end.service.IExceptionService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class ExceptionAspect {
    IExceptionService iExceptionService;

    public ExceptionAspect(IExceptionService iExceptionService) {
        this.iExceptionService = iExceptionService;
    }

    @Pointcut("within(com.example.waa_lab_7_back_end..*)")
    public void saveExceptionWithinPackage() {
    }

    @AfterThrowing(pointcut = "saveExceptionWithinPackage()", throwing = "exception")
    public void saveExceptionDetails(JoinPoint joinPoint, Throwable exception) {
        ExceptionEntity exceptionEntity = new ExceptionEntity();
        exceptionEntity.setDate(LocalDate.now());
        exceptionEntity.setTime(LocalTime.now());
        exceptionEntity.setOperation(joinPoint.getSignature().getName());
        exceptionEntity.setPrinciple("Fake User");
        exceptionEntity.setExceptionType(exception.getClass().getName());

        iExceptionService.save(exceptionEntity);
    }

}
