package com.example.waa_lab_8_back_end.service;

import com.example.waa_lab_8_back_end.entity.Logger;
import com.example.waa_lab_8_back_end.repo.ILoggerRepo;
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
