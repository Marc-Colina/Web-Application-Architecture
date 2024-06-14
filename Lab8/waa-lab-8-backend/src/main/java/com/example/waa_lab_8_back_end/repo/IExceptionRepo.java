package com.example.waa_lab_8_back_end.repo;

import com.example.waa_lab_8_back_end.entity.ExceptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExceptionRepo extends JpaRepository<ExceptionEntity, Long> {
}
