package com.possible.fashion.blog.controller;

import com.possible.fashion.blog.model.Customer;
import com.possible.fashion.blog.model.CustomerComment;
import com.possible.fashion.blog.model.Product;
import com.possible.fashion.blog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/")
public class ProductController {

    @Autowired
    private ProductService productService;

    //All the post for specific product
    @GetMapping("/api/products/{id}/comments")
    public List<CustomerComment> getAllComment(@PathVariable Long id){
        Product product = productService.findProductById(id);
        return product.getComments();
    }

    //create comment for specific product
    @PostMapping("/api/products/{id}/comments")
    public ResponseEntity<Object> createPost(@PathVariable Long id,  @Valid @RequestBody CustomerComment comment){
        productService.createPost(id, comment);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comment.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
