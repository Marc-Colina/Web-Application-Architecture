package com.example.waa_lab_5.repo;

import com.example.waa_lab_5.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoggerRepo extends JpaRepository<Logger, Long> {
}
