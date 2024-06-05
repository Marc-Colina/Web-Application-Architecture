package com.example.waa_lab_5.controller;

import com.example.waa_lab_5.entity.Post;
import com.example.waa_lab_5.entity.dto.request.PostRequestDTO;
import com.example.waa_lab_5.entity.dto.response.PostSimpleDTO;
import com.example.waa_lab_5.service.spec.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("posts")
public class PostController {

    private final IPostService postService;

    public PostController(IPostService postService) {
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
    public List<PostSimpleDTO> findAll(@RequestParam(required = false) Optional<String> author, @RequestParam Optional<String> title) {

        if (author.isPresent()) {
            return postService.findPostsByAuthor(author.get());
        } else if (title.isPresent()) {
            return postService.findByTitle(title.get());
        } else return postService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PostSimpleDTO findById(@PathVariable("id") long id) {
        return postService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PostRequestDTO save(@RequestBody PostRequestDTO postRequestDTO) {
        return postService.save(postRequestDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        postService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Post updateById(@PathVariable("id") long id, @RequestBody Post post) {
        return postService.updateById(id, post);
    }
}
