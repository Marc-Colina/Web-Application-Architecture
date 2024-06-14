package com.example.waa_lab_8_back_end.service;

import com.example.waa_lab_8_back_end.entity.Comment;
import com.example.waa_lab_8_back_end.entity.Post;
import com.example.waa_lab_8_back_end.entity.dto.request.PostRequestDTO;
import com.example.waa_lab_8_back_end.entity.dto.response.PostSimpleDTO;

import java.util.List;

public interface IPostService {
    List<PostSimpleDTO> findAll();

    PostSimpleDTO findById(long id);

    PostRequestDTO save(PostRequestDTO postRequestDTO);

    void deleteById(long id);

    Post updateById(long id, Post post);

    List<PostSimpleDTO> findPostsByAuthor(String author);

    List<PostSimpleDTO> findByTitle(String title);

    List<Comment> getCommentsByPostId(long postId);
}
