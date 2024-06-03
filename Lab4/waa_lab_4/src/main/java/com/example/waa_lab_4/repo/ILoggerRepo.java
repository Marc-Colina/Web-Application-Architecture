package com.example.waa_lab_4.repo;

import com.example.waa_lab_4.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoggerRepo extends JpaRepository<Logger, Long> {
}
