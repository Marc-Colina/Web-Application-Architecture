package com.example.waa_lab_4.repo;

import com.example.waa_lab_4.entity.ExceptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExceptionRepo extends JpaRepository<ExceptionEntity, Long> {
}
