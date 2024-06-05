package com.example.waa_lab_5.repo;

import com.example.waa_lab_5.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPostRepo extends JpaRepository<Post, Long> {
    List<Post> findByAuthorContaining(String author);

    List<Post> findByTitle(String title);
}
