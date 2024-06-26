package com.example.waa_lab_7_back_end.repo;

import com.example.waa_lab_7_back_end.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepo extends JpaRepository<Comment, Long> {
}
