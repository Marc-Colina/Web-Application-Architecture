package com.example.waa_lab_4.repo;

import com.example.waa_lab_4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IUserRepo extends JpaRepository<User, Long> {
    @Query("SELECT u, count(*) FROM User u JOIN u.posts p GROUP BY u HAVING COUNT(p) >= :minPosts")
    List<User> findAllUsersWithMinPost(@Param("minPosts") int minPosts);

    @Query("SELECT u FROM User u JOIN u.posts p WHERE p.title = :title")
    List<User> findAllUsersWithPostTitle(@Param("title") String title);
}
