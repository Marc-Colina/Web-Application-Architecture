package com.example.waa_lab_2.service;

import com.example.waa_lab_2.entity.User;
import com.example.waa_lab_2.entity.dto.response.PostSimpleDTO;
import com.example.waa_lab_2.entity.dto.response.UserSimpleDTO;

import java.util.List;

public interface IUserService {
    List<UserSimpleDTO> findAll();

    UserSimpleDTO findById(long id);

    void save(User user);

    List<PostSimpleDTO> findAllPostsByUserId(long id);

    List<UserSimpleDTO> findAllUsersWithMinPost(int minPosts);
}
