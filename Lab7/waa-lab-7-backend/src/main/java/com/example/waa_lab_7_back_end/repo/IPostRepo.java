package com.example.waa_lab_7_back_end.repo;

import com.example.waa_lab_7_back_end.entity.Comment;
import com.example.waa_lab_7_back_end.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPostRepo extends JpaRepository<Post, Long> {
    List<Post> findByAuthorContaining(String author);

    List<Post> findByTitle(String title);

    @Query("select p.comments from Post p where p.id= :postId")
    List<Comment> getCommentsByPostId(@Param("postId") long postId);
}
