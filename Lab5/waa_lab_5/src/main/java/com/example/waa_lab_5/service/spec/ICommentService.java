package com.example.waa_lab_5.service.spec;

import com.example.waa_lab_5.entity.Comment;
import com.example.waa_lab_5.entity.dto.request.CommentRequestDTO;

import java.util.List;


public interface ICommentService {

    List<Comment> findAll();

    CommentRequestDTO save(CommentRequestDTO commentRequestDTO);
}
