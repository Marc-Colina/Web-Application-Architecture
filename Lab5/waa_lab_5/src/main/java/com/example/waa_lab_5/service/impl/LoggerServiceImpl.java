package com.example.waa_lab_5.service.impl;

import com.example.waa_lab_5.entity.Logger;
import com.example.waa_lab_5.repo.ILoggerRepo;
import com.example.waa_lab_5.service.spec.ILoggerService;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements ILoggerService {
    private final ILoggerRepo iLoggerRepo;

    public LoggerServiceImpl(ILoggerRepo iLoggerRepo) {
        this.iLoggerRepo = iLoggerRepo;
    }

    @Override
    public Logger save(Logger logger) {
        return iLoggerRepo.save(logger);
    }
}
