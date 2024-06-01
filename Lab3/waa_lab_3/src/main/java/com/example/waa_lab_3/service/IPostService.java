package com.example.waa_lab_3.service;

import com.example.waa_lab_3.entity.Post;
import com.example.waa_lab_3.entity.dto.request.PostRequestDTO;
import com.example.waa_lab_3.entity.dto.response.PostSimpleDTO;

import java.util.List;

public interface IPostService {
    List<PostSimpleDTO> findAll();

    PostSimpleDTO findById(long id);

    PostRequestDTO save(PostRequestDTO postRequestDTO);

    void deleteById(long id);

    Post updateById(long id, Post post);

    List<PostSimpleDTO> findPostsByAuthor(String author);

    List<PostSimpleDTO> findByTitle(String title);
}
