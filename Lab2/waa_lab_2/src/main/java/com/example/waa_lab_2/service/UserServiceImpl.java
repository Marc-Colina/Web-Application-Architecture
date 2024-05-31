package com.example.waa_lab_2.service;

import com.example.waa_lab_2.entity.Post;
import com.example.waa_lab_2.entity.User;
import com.example.waa_lab_2.entity.dto.response.PostSimpleDTO;
import com.example.waa_lab_2.entity.dto.response.UserCustomDTO;
import com.example.waa_lab_2.entity.dto.response.UserSimpleDTO;
import com.example.waa_lab_2.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    UserRepo userRepo;
    ModelMapper modelMapper;

    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserSimpleDTO> findAll() {
        return userRepo.findAll().stream().map(user -> modelMapper.map(user, UserSimpleDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UserSimpleDTO findById(long id) {
        return modelMapper.map(userRepo.findById(id), UserSimpleDTO.class);
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public List<PostSimpleDTO> findAllPostsByUserId(long id) {
        Optional<User> user = userRepo.findById(id);
        List<Post> posts;

        if (user.isPresent()) {
            posts = user.get().getPosts();
            return posts.stream().map(post -> modelMapper.map(post, PostSimpleDTO.class)).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @Override
    public List<UserSimpleDTO> findAllUsersWithMinPost(int minPosts) {
        return userRepo.findAllUsersWithMinPost(minPosts).stream().map(UserCustomDTO::getUser).map(user -> modelMapper.map(user, UserSimpleDTO.class)).collect(Collectors.toList());
    }
}
