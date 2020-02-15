package com.possible.fashion.blog.service;

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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CommentRepository commentRepository;

    /* Product Service*/
    public Product findProductById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The required Product is not found"));
    }

    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Product productToUpdate, Long id){
        Product productFound =  productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The required Product is not found"));
        productFound.setImageSrc(productFound.getImageSrc());
        return productRepository.save(productFound);

    }

    public Map<String, Boolean> deleteProduct(Long id){
        Product productFound =  productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The required Product is not found"));
        productRepository.delete(productFound);

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
}
