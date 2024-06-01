package com.example.waa_lab_3.controller;

import com.example.waa_lab_3.entity.Comment;
import com.example.waa_lab_3.entity.dto.request.CommentRequestDTO;
import com.example.waa_lab_3.service.CommentServiceImpl;
import com.example.waa_lab_3.service.ICommentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comments")
public class CommentController {
    private final ICommentService iCommentService;

    public CommentController(ICommentService iCommentService) {
        this.iCommentService = iCommentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CommentRequestDTO save(@RequestBody CommentRequestDTO commentRequestDTO) {
        return iCommentService.save(commentRequestDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Comment> findAll() {
        return iCommentService.findAll();
    }
}
