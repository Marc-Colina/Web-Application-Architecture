package com.example.waa_lab_1.controller;

import com.example.waa_lab_1.entity.Post;
import com.example.waa_lab_1.entity.dto.response.PostSimpleDTO;
import com.example.waa_lab_1.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("posts")
public class PostController {

  PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  // This mapping takes care of Optional items g. and h. If we want to filter through a text (as
  // asked in letter h.), we can
  // provide an author string with
  // the partial text. If we also want to search via author's full name, then we should provide the
  // full name in the
  // request param.
  @ResponseStatus(HttpStatus.OK)
  @GetMapping
  public List<PostSimpleDTO> findAll(@RequestParam(required = false) Optional<String> author) {

    if (author.isPresent()) {
      System.out.println(author.get());
      return postService.findPostsByAuthor(author.get());
    } else return postService.findAll();
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/{id}")
  public PostSimpleDTO findById(@PathVariable("id") long id) {
    return postService.findById(id);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public Post save(@RequestBody Post post) {
    return postService.save(post);
  }

  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping("/{id}")
  public Post deleteById(@PathVariable("id") long id) {
    return postService.deleteById(id);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping("/{id}")
  public Post updateById(@PathVariable("id") long id, @RequestBody Post post) {
    return postService.updateById(id, post);
  }
}
