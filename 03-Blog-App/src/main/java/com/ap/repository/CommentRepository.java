package com.ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ap.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
