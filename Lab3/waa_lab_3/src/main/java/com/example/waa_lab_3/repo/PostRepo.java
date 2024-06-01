package com.example.waa_lab_3.repo;

import com.example.waa_lab_3.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> findByAuthorContaining(String author);

    List<Post> findByTitle(String title);
}
