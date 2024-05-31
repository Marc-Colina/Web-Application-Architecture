package com.example.waa_lab_2.service;

import com.example.waa_lab_2.entity.Post;
import com.example.waa_lab_2.entity.dto.response.PostSimpleDTO;

import java.util.List;

public interface IPostService {
    List<PostSimpleDTO> findAll();

    PostSimpleDTO findById(long id);

    Post save(Post post);

    void deleteById(long id);

    Post updateById(long id, Post post);

    List<PostSimpleDTO> findPostsByAuthor(String author);
}
