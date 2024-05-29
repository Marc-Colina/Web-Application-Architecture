package com.example.waa_lab_1.repo;

import com.example.waa_lab_1.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostRepo {
  List<Post> findAll();

  Post findById(long id);

  Post save(Post post);

  Post deleteById(long id);

  Post updateById(long id, Post post);

  List<Post> findPostsByAuthor(String author);
}
