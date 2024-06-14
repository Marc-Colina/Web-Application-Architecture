package com.example.waa_lab_8_back_end.service;

import com.example.waa_lab_8_back_end.entity.Comment;
import com.example.waa_lab_8_back_end.entity.dto.request.CommentRequestDTO;

import java.util.List;


public interface ICommentService {

    List<Comment> findAll();

    CommentRequestDTO save(CommentRequestDTO commentRequestDTO);
}
