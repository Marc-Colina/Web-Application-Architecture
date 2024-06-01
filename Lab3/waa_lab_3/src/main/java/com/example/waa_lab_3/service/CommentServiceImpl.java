package com.example.waa_lab_3.service;

import com.example.waa_lab_3.entity.Comment;
import com.example.waa_lab_3.entity.Post;
import com.example.waa_lab_3.entity.dto.request.CommentRequestDTO;
import com.example.waa_lab_3.repo.CommentRepo;
import com.example.waa_lab_3.repo.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements ICommentService {

    private final PostRepo postRepo;
    private final CommentRepo commentRepo;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepo commentRepo, PostRepo postRepo, ModelMapper modelMapper) {
        this.commentRepo = commentRepo;
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepo.findAll();
    }

    @Override
    public CommentRequestDTO save(CommentRequestDTO commentRequestDTO) {
        Optional<Post> post = postRepo.findById(commentRequestDTO.getPost_id());
        if (post.isPresent()) {
            Comment comment = modelMapper.map(commentRequestDTO, Comment.class);
            post.get().getComments().add(comment);
            postRepo.save(post.get());
            return commentRequestDTO;
        }
        return null;
    }


}
