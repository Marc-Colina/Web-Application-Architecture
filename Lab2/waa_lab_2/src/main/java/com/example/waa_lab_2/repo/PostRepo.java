package com.example.waa_lab_2.repo;

import com.example.waa_lab_2.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
  List<Post> findByAuthorContaining(String author);
}
