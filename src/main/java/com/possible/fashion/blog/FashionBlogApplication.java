package com.possible.fashion.blog;

import com.possible.fashion.blog.model.Customer;
import com.possible.fashion.blog.model.Product;
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
/*        Product pr1 = new Product();
        pr1.setImageSrc("img_234");
        productService.createProduct(pr1);

        Product pr2 = new Product();
        pr2.setImageSrc("img_235");

        productService.createProduct(pr2);
        Product pr3 = new Product();
        pr3.setImageSrc("img_236");
        productService.createProduct(pr3);

        Product pr4 = new Product();
        pr4.setImageSrc("img_237");
        productService.createProduct(pr4);

        Customer c1 = new Customer("ade", "ade@gmail.com");
        customerRepository.save(c1);

        Customer c2 = new Customer("Wade", "wade@gmail.com");
        customerRepository.save(c2);

        Customer c3 = new Customer("Tade", "tade@gmail.com");
        customerRepository.save(c3);

        Customer c4 = new Customer("lade", "lade@gmail.com");*/
        //customerRepository.save(c4);



    }
}
