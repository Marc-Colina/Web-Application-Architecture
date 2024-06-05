package com.example.waa_lab_5.service.impl;

import com.example.waa_lab_5.entity.ExceptionEntity;
import com.example.waa_lab_5.repo.IExceptionRepo;
import com.example.waa_lab_5.service.spec.IExceptionService;
import org.springframework.stereotype.Service;

@Service
public class ExceptionServiceImpl implements IExceptionService {

    private final IExceptionRepo iExceptionRepo;

    public ExceptionServiceImpl(IExceptionRepo iExceptionRepo) {
        this.iExceptionRepo = iExceptionRepo;
    }

    @Override
    public ExceptionEntity save(ExceptionEntity exceptionEntity) {
        return iExceptionRepo.save(exceptionEntity);
    }
}
