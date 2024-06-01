package com.example.waa_lab_3.service;

import com.example.waa_lab_3.entity.Post;
import com.example.waa_lab_3.entity.User;
import com.example.waa_lab_3.entity.dto.request.PostRequestDTO;
import com.example.waa_lab_3.entity.dto.response.PostSimpleDTO;
import com.example.waa_lab_3.repo.PostRepo;
import com.example.waa_lab_3.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {

    private final UserRepo userRepo;
    PostRepo postRepo;
    ModelMapper modelMapper;

    public PostServiceImpl(PostRepo postRepo, ModelMapper modelMapper, UserRepo userRepo) {
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
        this.userRepo = userRepo;
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
    public PostRequestDTO save(PostRequestDTO postRequestDTO) {
        Optional<User> user = userRepo.findById(postRequestDTO.getUser_id());

        if (user.isPresent()) {
            Post post = modelMapper.map(postRequestDTO, Post.class);
            user.get().getPosts().add(post);
            userRepo.save(user.get());
            return postRequestDTO;
        }
        return null;
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

    @Override
    public List<PostSimpleDTO> findByTitle(String title) {
        return postRepo.findByTitle(title).stream().map(post -> modelMapper.map(post, PostSimpleDTO.class)).collect(Collectors.toList());
    }
}
