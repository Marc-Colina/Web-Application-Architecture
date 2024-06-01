package com.example.waa_lab_3.service;

import com.example.waa_lab_3.entity.Comment;
import com.example.waa_lab_3.entity.dto.request.CommentRequestDTO;
import com.example.waa_lab_3.repo.CommentRepo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICommentService {

    List<Comment> findAll();

    CommentRequestDTO save(CommentRequestDTO commentRequestDTO);
}
