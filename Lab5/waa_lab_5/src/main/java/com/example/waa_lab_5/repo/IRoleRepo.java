package com.example.waa_lab_5.repo;

import com.example.waa_lab_5.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepo extends JpaRepository<Role, Long> {
}
