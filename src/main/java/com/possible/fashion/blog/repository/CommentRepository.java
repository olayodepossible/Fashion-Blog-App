package com.possible.fashion.blog.repository;

import com.possible.fashion.blog.model.Comment;
import com.possible.fashion.blog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository  extends JpaRepository<Comment, Long> {
    public List<Comment> findCommentByProductId(Long id);
    public List<Comment> findCommentByCustomerId(Long id);
}
