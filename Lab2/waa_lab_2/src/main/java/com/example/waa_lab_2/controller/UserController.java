package com.example.waa_lab_2.controller;

import com.example.waa_lab_2.entity.User;
import com.example.waa_lab_2.entity.dto.response.PostSimpleDTO;
import com.example.waa_lab_2.entity.dto.response.UserSimpleDTO;
import com.example.waa_lab_2.service.IUserService;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserSimpleDTO> findAll(@RequestParam(required = false) Optional<Integer> minPosts) {
        if (minPosts.isPresent()) {
            System.out.println(minPosts.get());
            return userService.findAllUsersWithMinPost(minPosts.get());
        } else
            return userService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    public UserSimpleDTO findById(@PathVariable("id") long id) {
        return userService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}/posts")
    public List<PostSimpleDTO> findAllPostsByUser(@PathVariable("id") long id) {
        return userService.findAllPostsByUserId(id);
    }


}
