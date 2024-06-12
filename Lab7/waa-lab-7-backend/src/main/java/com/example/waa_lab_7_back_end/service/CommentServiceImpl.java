package com.example.waa_lab_7_back_end.service;

import com.example.waa_lab_7_back_end.entity.Comment;
import com.example.waa_lab_7_back_end.entity.Post;
import com.example.waa_lab_7_back_end.entity.dto.request.CommentRequestDTO;
import com.example.waa_lab_7_back_end.repo.ICommentRepo;
import com.example.waa_lab_7_back_end.repo.IPostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements ICommentService {

    private final IPostRepo IPostRepo;
    private final ICommentRepo ICommentRepo;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(ICommentRepo ICommentRepo, IPostRepo IPostRepo, ModelMapper modelMapper) {
        this.ICommentRepo = ICommentRepo;
        this.IPostRepo = IPostRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Comment> findAll() {
        return ICommentRepo.findAll();
    }

    @Override
    public CommentRequestDTO save(CommentRequestDTO commentRequestDTO) {
        Optional<Post> post = IPostRepo.findById(commentRequestDTO.getPost_id());
        if (post.isPresent()) {
            Comment comment = modelMapper.map(commentRequestDTO, Comment.class);
            post.get().getComments().add(comment);
            IPostRepo.save(post.get());
            return commentRequestDTO;
        }
        return null;
    }


}
