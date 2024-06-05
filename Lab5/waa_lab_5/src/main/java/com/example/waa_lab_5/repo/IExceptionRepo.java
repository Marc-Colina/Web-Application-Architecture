package com.example.waa_lab_5.repo;

import com.example.waa_lab_5.entity.ExceptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExceptionRepo extends JpaRepository<ExceptionEntity, Long> {
}
