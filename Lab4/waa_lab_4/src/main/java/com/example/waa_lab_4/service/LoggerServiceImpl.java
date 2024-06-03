package com.example.waa_lab_4.service;

import com.example.waa_lab_4.entity.Logger;
import com.example.waa_lab_4.repo.ILoggerRepo;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements ILoggerService {
    ILoggerRepo iLoggerRepo;

    public LoggerServiceImpl(ILoggerRepo iLoggerRepo) {
        this.iLoggerRepo = iLoggerRepo;
    }

    @Override
    public Logger save(Logger logger) {
        return iLoggerRepo.save(logger);
    }
}
