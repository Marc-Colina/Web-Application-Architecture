package com.example.waa_lab_4.aspect;

import com.example.waa_lab_4.entity.ExceptionEntity;
import com.example.waa_lab_4.repo.IExceptionRepo;
import com.example.waa_lab_4.service.IExceptionService;
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

    @Pointcut("within(com.example.waa_lab_4..*)")
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
