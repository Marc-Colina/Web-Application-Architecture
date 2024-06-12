package com.example.waa_lab_7_back_end.controller;

import com.example.waa_lab_7_back_end.aspect.annotation.ExecutionTime;
import com.example.waa_lab_7_back_end.entity.User;
import com.example.waa_lab_7_back_end.entity.dto.response.PostSimpleDTO;
import com.example.waa_lab_7_back_end.entity.dto.response.UserSimpleDTO;
import com.example.waa_lab_7_back_end.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("users")
public class UserController {

    IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    //Making this method throw an exception just to test the ExceptionAspect
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserSimpleDTO> findAll(@RequestParam(required = false) Optional<Integer> minPosts, @RequestParam(required = false) Optional<String> title) {
        throw new RuntimeException();
//
//        if (minPosts.isPresent()) {
//            return userService.findAllUsersWithMinPost(minPosts.get());
//        } else if (title.isPresent()) {
//            return userService.findAllUsersWithPostTitle(title.get());
//        } else
//            return userService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    @ExecutionTime
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

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") long id) {
        userService.deleteById(id);
    }
}
