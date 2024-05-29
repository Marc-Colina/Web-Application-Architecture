package com.example.waa_lab_1.service;

import com.example.waa_lab_1.entity.Post;
import com.example.waa_lab_1.entity.dto.response.PostSimpleDTO;
import com.example.waa_lab_1.repo.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

  PostRepo postRepo;
  ModelMapper modelMapper;

  public PostServiceImpl(PostRepo postRepo, ModelMapper modelMapper) {
    this.postRepo = postRepo;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<PostSimpleDTO> findAll() {
    return postRepo.findAll().stream()
        .map(post -> modelMapper.map(post, PostSimpleDTO.class))
        .collect(Collectors.toList());
  }

  @Override
  public PostSimpleDTO findById(long id) {
    return modelMapper.map(postRepo.findById(id), PostSimpleDTO.class);
  }

  @Override
  public Post save(Post post) {
    return postRepo.save(post);
  }

  @Override
  public Post deleteById(long id) {
    return postRepo.deleteById(id);
  }

  @Override
  public Post updateById(long id, Post post) {
    return postRepo.updateById(id, post);
  }

  @Override
  public List<PostSimpleDTO> findPostsByAuthor(String author) {
    return postRepo.findPostsByAuthor(author).stream()
        .map(post -> modelMapper.map(post, PostSimpleDTO.class))
        .collect(Collectors.toList());
  }
}
