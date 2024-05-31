package com.example.waa_lab_2.service;

import com.example.waa_lab_2.entity.Post;
import com.example.waa_lab_2.entity.dto.response.PostSimpleDTO;
import com.example.waa_lab_2.repo.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {

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
    public void deleteById(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public Post updateById(long id, Post post) {
        Optional<Post> postToUpdate = postRepo.findById(id);
        if (postToUpdate.isPresent()) {
            post.setId(id);
            return postRepo.save(post);
        }
        return null;
    }

    @Override
    public List<PostSimpleDTO> findPostsByAuthor(String author) {
        return postRepo.findByAuthorContaining(author).stream()
                .map(post -> modelMapper.map(post, PostSimpleDTO.class))
                .collect(Collectors.toList());
    }
}
