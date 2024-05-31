package com.example.waa_lab_2.repo;

import com.example.waa_lab_2.entity.User;
import com.example.waa_lab_2.entity.dto.response.UserCustomDTO;
import com.example.waa_lab_2.entity.dto.response.UserSimpleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepo extends JpaRepository<User, Long> {
    @Query("SELECT new com.example.waa_lab_2.entity.dto.response.UserCustomDTO(u, COUNT(p)) FROM User u JOIN u.posts p GROUP BY u HAVING COUNT(p) >= :minPosts")
    List<UserCustomDTO> findAllUsersWithMinPost(@Param("minPosts") int minPosts);
}
