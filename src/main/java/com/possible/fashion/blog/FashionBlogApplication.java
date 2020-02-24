package com.possible.fashion.blog;

import com.possible.fashion.blog.model.Customer;
import com.possible.fashion.blog.model.Comment;
import com.possible.fashion.blog.model.Product;
import com.possible.fashion.blog.repository.CommentRepository;
import com.possible.fashion.blog.repository.CustomerRepository;
import com.possible.fashion.blog.repository.ProductRepository;
import com.possible.fashion.blog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FashionBlogApplication  implements CommandLineRunner {

    private ProductService productService;
    private CustomerRepository customerRepository;
    private CommentRepository commentRepository;
    @Autowired
    private  ProductRepository productRepository;

    @Autowired
    public void commentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Autowired
    public void productService(ProductService productService) {
        this.productService = productService;
    }
    @Autowired
    public void customerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FashionBlogApplication.class, args);
    }



    @Override
    public void run(String... args) throws Exception {
        Product pr1 = new Product();
        pr1.setName("Product-1");
        pr1.setPrice(12.56);
        pr1.setDescription("Nice outfit");
        pr1.setImageSrc("img_234");
        //productRepository.save(pr1);
        productService.createProduct(pr1);

        Product pr2 = new Product();
        pr2.setName("Product-2");
        pr2.setPrice(10.56);
        pr2.setDescription("Nice outfit -2");
        pr2.setImageSrc("img_235");
        //productRepository.save(pr2);
        productService.createProduct(pr2);

        Product pr3 = new Product();
        pr3.setName("Product-3");
        pr3.setPrice(122.56);
        pr3.setDescription("Nice outfit-3");
        pr3.setImageSrc("img_236");
      //  productRepository.save(pr3);
        productService.createProduct(pr3);

        Product pr4 = new Product();
        pr4.setName("Product-4");
        pr4.setPrice(12.56);
        pr4.setDescription("Nice outfit-4");
        pr4.setImageSrc("img_237");
        //productRepository.save(pr4);
        productService.createProduct(pr4);


        Customer c1 = new Customer("ade", "ade@gmail.com");
        customerRepository.save(c1);

        Customer c2 = new Customer("Wade", "wade@gmail.com");

        customerRepository.save(c2);

        Customer c3 = new Customer("Tade", "tade@gmail.com");

        customerRepository.save(c3);

        Customer c4 = new Customer("lade", "lade@gmail.com");
        customerRepository.save(c4);



        Comment com1 = new Comment("This is good from Ade --> 1");
        com1.setProduct(pr1);
        com1.setCustomer(c1);
        commentRepository.save(com1);

        Comment com2 = new Comment("This is good From Lade --> 1");
        com2.setProduct(pr1);
        com2.setCustomer(c4);
        commentRepository.save(com2);

        Comment com3 = new Comment("This is good From Tade --> 1");
        com3.setProduct(pr1);
        com3.setCustomer(c3);
        commentRepository.save(com3);

        Comment com4 = new Comment("This is good From Wade --> 1");
        com4.setProduct(pr1);
        com4.setCustomer(c2);
        commentRepository.save(com4);



        Comment com5 = new Comment("This is good --> 2");
        com5.setProduct(pr2);
        com5.setCustomer(c2);
        commentRepository.save(com5);

        Comment com6 = new Comment("This is good --> 3");
        com6.setProduct(pr3);
        com6.setCustomer(c3);
        commentRepository.save(com6);

        Comment com7 = new Comment("This is good --> 4");
        com7.setProduct(pr4);
        com7.setCustomer(c4);
        commentRepository.save(com7);

    }
}
