package com.example.waa_lab_5.repo;

import com.example.waa_lab_5.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepo extends JpaRepository<Comment, Long> {
}
