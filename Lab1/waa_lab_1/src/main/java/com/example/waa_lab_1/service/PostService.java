package com.example.waa_lab_1.service;

import com.example.waa_lab_1.entity.Post;
import com.example.waa_lab_1.entity.dto.response.PostSimpleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {
  List<PostSimpleDTO> findAll();

  PostSimpleDTO findById(long id);

  Post save(Post post);

  Post deleteById(long id);

  Post updateById(long id, Post post);

  List<PostSimpleDTO> findPostsByAuthor(String author);
}
