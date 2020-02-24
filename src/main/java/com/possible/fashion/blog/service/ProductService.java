package com.possible.fashion.blog.service;

import com.possible.fashion.blog.exception.ResourceNotFoundException;
import com.possible.fashion.blog.model.Customer;
import com.possible.fashion.blog.model.Comment;
import com.possible.fashion.blog.model.Product;
import com.possible.fashion.blog.repository.CommentRepository;
import com.possible.fashion.blog.repository.CustomerRepository;
import com.possible.fashion.blog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private ProductRepository productRepository;

    private CustomerRepository customerRepository;


    private CommentRepository commentRepository;
    @Autowired
    public void productRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void customerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    public void commentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    /* Product Service*/
    public Product findProductById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The required Resource is not found"));
    }

    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Product productToUpdate, Long id){
        Product productFound =  productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The required Resource is not found"));
        productFound.setImageSrc(productToUpdate.getImageSrc());
        return productRepository.save(productFound);

    }

    public Boolean deleteProduct(Long id){
        Product productFound =  productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The required Resource is not found"));
        productRepository.delete(productFound);
        return true;
    }

    /*  Customer Service*/
    public Customer findCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The required Resource is not found"));
    }

    public List<Customer> findAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customerToUpdate, Long id){
        Customer customerFound =  customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The required Resource is not found"));
        customerFound.setName(customerToUpdate.getName());
        customerFound.setEmail(customerFound.getEmail());
        return customerRepository.save(customerFound);

    }

    public Boolean deleteCustomer(Long id){
        Customer customerFound = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The required Resource is not found"));
        customerRepository.delete(customerFound);
        return true;
    }

    /* Customer's Comment Service*/

    public Comment createPost(Long product_id, Long customer_id, Comment post){
        Product product = productRepository.findById(product_id).orElseThrow(() -> new ResourceNotFoundException("The Product does not exit"));
        post.setProduct(product);

        Customer customer = customerRepository.findById(customer_id).orElseThrow(() -> new ResourceNotFoundException("No comment from this resource"));
        post.setCustomer(customer);
        return  commentRepository.save(post);
    }

    //Fetch All the post for Specific customer
    public List<Comment> getCommentByCustomerId(Long id){
        return commentRepository.findCommentByCustomerId(id);
    }

    public List<Comment> findCommentByProductId(Long id){
        return commentRepository.findCommentByProductId(id);
    }

    public Comment updatePost(Long id, Comment postToUpdate){
        Comment updatedPost = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The Product does not exit"));
        updatedPost.setComment(postToUpdate.getComment());
        return commentRepository.save(updatedPost);
    }

    public Boolean deletePost(Long id){
        Comment postFound =  commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The required Resource is not found"));
        commentRepository.delete(postFound);
        return true;
    }

}
