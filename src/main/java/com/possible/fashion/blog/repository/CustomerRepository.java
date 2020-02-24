package com.possible.fashion.blog.repository;

import com.possible.fashion.blog.model.Comment;
import com.possible.fashion.blog.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
