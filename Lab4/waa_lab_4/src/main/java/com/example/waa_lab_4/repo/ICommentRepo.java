package com.example.waa_lab_4.repo;

import com.example.waa_lab_4.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepo extends JpaRepository<Comment, Long> {
}
