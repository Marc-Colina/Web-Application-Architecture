package com.example.waa_lab_5.service.impl;

import com.example.waa_lab_5.entity.Post;
import com.example.waa_lab_5.entity.User;
import com.example.waa_lab_5.entity.dto.request.PostRequestDTO;
import com.example.waa_lab_5.entity.dto.response.PostSimpleDTO;
import com.example.waa_lab_5.repo.IPostRepo;
import com.example.waa_lab_5.repo.IUserRepo;
import com.example.waa_lab_5.service.spec.IPostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {

    private final IUserRepo IUserRepo;
    private final IPostRepo IPostRepo;
    private final ModelMapper modelMapper;

    public PostServiceImpl(IPostRepo IPostRepo, ModelMapper modelMapper, IUserRepo IUserRepo) {
        this.IPostRepo = IPostRepo;
        this.modelMapper = modelMapper;
        this.IUserRepo = IUserRepo;
    }

    @Override
    public List<PostSimpleDTO> findAll() {
        return IPostRepo.findAll().stream()
                .map(post -> modelMapper.map(post, PostSimpleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostSimpleDTO findById(long id) {
        return modelMapper.map(IPostRepo.findById(id), PostSimpleDTO.class);
    }

    @Override
    public PostRequestDTO save(PostRequestDTO postRequestDTO) {
        Optional<User> user = IUserRepo.findById(postRequestDTO.getUser_id());

        if (user.isPresent()) {
            Post post = modelMapper.map(postRequestDTO, Post.class);
            user.get().getPosts().add(post);
            IUserRepo.save(user.get());
            return postRequestDTO;
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        IPostRepo.deleteById(id);
    }

    @Override
    public Post updateById(long id, Post post) {
        Optional<Post> postToUpdate = IPostRepo.findById(id);
        if (postToUpdate.isPresent()) {
            post.setId(id);
            return IPostRepo.save(post);
        }
        return null;
    }

    @Override
    public List<PostSimpleDTO> findPostsByAuthor(String author) {
        return IPostRepo.findByAuthorContaining(author).stream()
                .map(post -> modelMapper.map(post, PostSimpleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostSimpleDTO> findByTitle(String title) {
        return IPostRepo.findByTitle(title).stream().map(post -> modelMapper.map(post, PostSimpleDTO.class))
                .collect(Collectors.toList());
    }
}
