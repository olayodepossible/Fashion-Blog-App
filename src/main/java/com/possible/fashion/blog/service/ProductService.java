package com.possible.fashion.blog.service;

import com.possible.fashion.blog.exception.ResourceNotFoundException;
import com.possible.fashion.blog.model.Customer;
import com.possible.fashion.blog.model.CustomerComment;
import com.possible.fashion.blog.model.Product;
import com.possible.fashion.blog.repository.CommentRepository;
import com.possible.fashion.blog.repository.CustomerRepository;
import com.possible.fashion.blog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public Map<String, Boolean> deleteProduct(Long id){
        Product productFound =  productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The required Resource is not found"));
        productRepository.delete(productFound);

        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
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

    public Map<String, Boolean> deleteCustomer(Long id){
        Customer customerFound = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The required Resource is not found"));
        customerRepository.delete(customerFound);

        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }

    /* Customer's Comment Service*/

    public CustomerComment createPost(Long id, CustomerComment post){
        Product product = findProductById(id);
        post.setProduct(product);
        return  commentRepository.save(post);
    }

    public CustomerComment updatePost(CustomerComment postToUpdate, Long id){
        Product productFound = findProductById(id);
        CustomerComment updatedPost =  productFound.getComments().get( postToUpdate.getId().intValue());
        updatedPost.setComment(postToUpdate.getComment());
        return commentRepository.save(updatedPost);
    }

    public Map<String, Boolean> deletePost(Long id){
       CustomerComment postFound =  commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The required Resource is not found"));
        commentRepository.delete(postFound);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }

}
