package com.example.waa_lab_8_back_end.repo;

import com.example.waa_lab_8_back_end.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoggerRepo extends JpaRepository<Logger, Long> {
}
