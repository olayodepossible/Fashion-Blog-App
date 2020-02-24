package com.possible.fashion.blog.controller;

import com.possible.fashion.blog.exception.CommentNotFoundException;
import com.possible.fashion.blog.model.Customer;
import com.possible.fashion.blog.model.Comment;
import com.possible.fashion.blog.model.Product;
import com.possible.fashion.blog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductController {


    private ProductService productService;

    @Autowired
    public void productService(ProductService productService) {
        this.productService = productService;
    }

    // Home page
    @GetMapping("/")
    public ResponseEntity<Object> home(){
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to Home page try me");
        return ResponseEntity.ok().body(response);
    }

/*    @GetMapping("/users")
    public ResponseEntity<Object> user(){
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome User");
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/admin")
    public ResponseEntity<Object> admin(){
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome Admin");
        return ResponseEntity.ok().body(response);
    }*/



    //Get All Product
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products =  productService.findAllProduct();
        return ResponseEntity.ok().body(products);
    }


/*    //Get Product by Id
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable (value = "id") Long id){
        Product foundProduct =  productService.findProductById(id);
        return  ResponseEntity.ok().body(foundProduct);
    }*/

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable (value = "id") Long id){
        Product foundProduct =  productService.findProductById(id);
        return foundProduct;
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

        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", productService.deleteProduct(id));
        return response;

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
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", productService.deleteCustomer(id));
        return response;

    }


    // Fetch All the post for specific product
    @GetMapping("/products/{id}/comments")
    public ResponseEntity<List<Comment>> getCommentForProduct(@PathVariable Long id){
        List<Comment> comments = productService.findCommentByProductId(id);
        return  ResponseEntity.ok(comments);
    }

    //Fetch All the post for Specific customer
    @GetMapping("/customer/{id}/comments")
    public ResponseEntity<List<Comment>> getAllCustomerComments(@PathVariable(value = "id") Long id){
        List<Comment> comments = productService.getCommentByCustomerId(id);
        return ResponseEntity.ok().body(comments);
    }

    //create comment for specific product
    @PostMapping("/products/{product_id}/comments/{customer_id}")
    public ResponseEntity<Comment> createPost(@PathVariable(value = "product_id") Long product_id, @PathVariable(value = "customer_id") Long customer_id, @Valid @RequestBody Comment comment){
        productService.createPost(product_id, customer_id, comment);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comment.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    //Update Comment
    @PutMapping("/products/comments/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable(value = "id") Long id, @Valid @RequestBody Comment comment){
        Comment updatedPost = productService.updatePost(id, comment );
        return  ResponseEntity.ok(updatedPost);
    }

    //Delete comment
    @DeleteMapping("/products/comments/{id}")
    public Map<String, Boolean> deleteComment(@PathVariable(value = "id") Long id){
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", productService.deletePost(id));
        return response;
    }

}
