package com.example.waa_lab_1.repo;

import com.example.waa_lab_1.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {
  private static List<Post> posts;
  private static int postId = 4;

  static {
    // Add some initial data
    posts = new ArrayList<>();
    posts.add(new Post(1, "First time in the US", "Had a great time at Hawaii!", "Marc Colina"));
    posts.add(
        new Post(
            2,
            "Singing with my Boyfriend",
            "Had fun singing with my childhood sweetheart",
            "Mary Colina"));
    posts.add(
        new Post(
            3,
            "Defeating my boyfie in Monopolu",
            "I outsmarted and outstrategized my boyfie and his friends",
            "Rose Mabelle Seares"));
  }

  @Override
  public List<Post> findAll() {
    return posts;
  }

  @Override
  public Post findById(long id) {
    return posts.stream().filter(post -> post.getId() == id).findFirst().orElse(null);
  }

  @Override
  public Post save(Post post) {
    post.setId(postId);
    postId++;
    posts.add(post);
    return post;
  }

  @Override
  public Post deleteById(long id) {
    Optional<Post> postToDelete = posts.stream().filter(post -> post.getId() == id).findFirst();
    postToDelete.ifPresent(post -> posts.remove(post));
    return postToDelete.orElse(null);
  }

  @Override
  public Post updateById(long id, Post post) {
    Post postToUpdate = findById(id);
    if (postToUpdate != null) {
      postToUpdate.setAuthor(post.getAuthor());
      postToUpdate.setContent(post.getContent());
      postToUpdate.setTitle(post.getTitle());
    }
    return postToUpdate;
  }

  @Override
  public List<Post> findPostsByAuthor(String author) {
    return posts.stream()
        .filter(
            post -> post.getAuthor().equalsIgnoreCase(author) || post.getAuthor().contains(author))
        .collect(Collectors.toList());
  }
}
