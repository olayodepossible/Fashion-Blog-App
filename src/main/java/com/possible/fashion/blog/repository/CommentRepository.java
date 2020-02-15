package com.possible.fashion.blog.repository;

import com.possible.fashion.blog.model.CustomerComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository  extends JpaRepository<CustomerComment, Long> {

}
