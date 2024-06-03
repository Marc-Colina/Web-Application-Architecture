package com.example.waa_lab_4.service;

import com.example.waa_lab_4.entity.Comment;
import com.example.waa_lab_4.entity.dto.request.CommentRequestDTO;

import java.util.List;


public interface ICommentService {

    List<Comment> findAll();

    CommentRequestDTO save(CommentRequestDTO commentRequestDTO);
}
