package com.possible.fashion.blog.controller;

import com.possible.fashion.blog.exception.CommentNotFoundException;
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
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/")
public class ProductController {


    private ProductService productService;

    @Autowired
    public void productService(ProductService productService) {
        this.productService = productService;
    }

    //Get All Product
    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return productService.findAllProduct();
    }

    //Get Product by Id
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable (value = "id") Long id){
        Product foundProduct =  productService.findProductById(id);
        System.out.println("THIS IS THE RESULT FROM GET PRODUCT BY ID >>>>>>>>>>>>>>>> "+ foundProduct );
        return  ResponseEntity.ok().body(foundProduct);
    }

    //save Product
    @PostMapping("/products")
    public Product createProduct(@Valid @RequestBody Product productToSave){
        return productService.createProduct(productToSave);
    }

    //Update Product
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long id, @Valid @RequestBody Product product){
        Product updatedProduct = productService.updateProduct(product, id);
        return  ResponseEntity.ok(updatedProduct);
    }

    //Delete Product
    @DeleteMapping("/products/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long id){
        return  productService.deleteProduct(id);
    }


    //Fetch All Customer
    @GetMapping("/customers")
    public List<Customer> getAllCustomer(){
        return productService.findAllCustomer();
    }

    //Fetch Customer by Id
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable (value = "id") Long id){
        Customer foundCustomer =  productService.findCustomerById(id);
        return  ResponseEntity.ok().body(foundCustomer);
    }

    //Create Customer
    @PostMapping("/customers")
    public Customer createCustomer(@Valid @RequestBody Customer customerToSave){
        return productService.createCustomer(customerToSave);
    }

    //Update Customer
    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long id, @Valid @RequestBody Customer customer){
        Customer updatedCustomer = productService.updateCustomer(customer, id);
        return  ResponseEntity.ok(updatedCustomer);
    }

    //Delete Customer
    @DeleteMapping("/customers/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long id){
        return  productService.deleteCustomer(id);
    }


    // Fetch All the post for specific product
    @GetMapping("/products/{id}/comments")
    public List<CustomerComment> getAllComment(@PathVariable Long id){
        Product product = productService.findProductById(id);
        if (product.getComments() == null) {
            throw  new CommentNotFoundException("The resource has no comment");
        }
        return product.getComments();
    }

    //create comment for specific product
    @PostMapping("/products/{id}/comments")
    public ResponseEntity<CustomerComment> createPost(@PathVariable Long id,  @Valid @RequestBody CustomerComment comment){
        productService.createPost(id, comment);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comment.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    //Update Comment
    @PutMapping("/products/{id}/comments")
    public ResponseEntity<CustomerComment> updateComment(@PathVariable(value = "id") Long id, @Valid @RequestBody CustomerComment comment){
        CustomerComment updatedPost = productService.updatePost(comment, id);
        return  ResponseEntity.ok(updatedPost);
    }

    //Delete comment
    @DeleteMapping("/products/{id}/comments")
    public Map<String, Boolean> deleteComment(@PathVariable(value = "id") Long id){
        return  productService.deletePost(id);
    }






}
