package com.example.waa_lab_4.service;

import com.example.waa_lab_4.entity.ExceptionEntity;
import com.example.waa_lab_4.repo.IExceptionRepo;
import org.springframework.stereotype.Service;

@Service
public class ExceptionServiceImpl implements IExceptionService {

    IExceptionRepo iExceptionRepo;

    public ExceptionServiceImpl(IExceptionRepo iExceptionRepo) {
        this.iExceptionRepo = iExceptionRepo;
    }

    @Override
    public ExceptionEntity save(ExceptionEntity exceptionEntity) {
        return iExceptionRepo.save(exceptionEntity);
    }
}
