package com.example.waa_lab_8_back_end.service;

import com.example.waa_lab_8_back_end.entity.Post;
import com.example.waa_lab_8_back_end.entity.User;
import com.example.waa_lab_8_back_end.entity.dto.response.PostSimpleDTO;
import com.example.waa_lab_8_back_end.entity.dto.response.UserSimpleDTO;
import com.example.waa_lab_8_back_end.repo.IUserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    IUserRepo IUserRepo;
    ModelMapper modelMapper;

    public UserServiceImpl(IUserRepo IUserRepo, ModelMapper modelMapper) {
        this.IUserRepo = IUserRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserSimpleDTO> findAll() {
        return IUserRepo.findAll().stream().map(user -> modelMapper.map(user, UserSimpleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserSimpleDTO findById(long id) {
        return modelMapper.map(IUserRepo.findById(id), UserSimpleDTO.class);
    }

    @Override
    public void save(User user) {

        IUserRepo.save(user);
    }

    @Override
    public List<PostSimpleDTO> findAllPostsByUserId(long id) {
        Optional<User> user = IUserRepo.findById(id);
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
        return IUserRepo.findAllUsersWithMinPost(minPosts).stream()
                .map(user -> modelMapper.map(user, UserSimpleDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(long id) {
        IUserRepo.deleteById(id);
    }

    @Override
    public List<UserSimpleDTO> findAllUsersWithPostTitle(String title) {
        return IUserRepo.findAllUsersWithPostTitle(title).stream()
                .map(user -> modelMapper.map(user, UserSimpleDTO.class)).collect(Collectors.toList());
    }
}
