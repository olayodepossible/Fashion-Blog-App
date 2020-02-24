package com.possible.fashion.blog.unittest;

import static org.assertj.core.api.Assertions.assertThat;
import com.possible.fashion.blog.model.Product;
import org.junit.jupiter.api.Test;



public class ProductUnitTest {
    @Test
    public void whenCalledGetImageSource(){
        Product product = new Product("product-1", 12.0, "cool", "image_234");
        assertThat(product.getImageSrc()).isEqualTo("image_234");
    }

    public void whenCalledSetImageSource(){
        Product product = new Product("product-1", 12.0, "cool", "image_234");
        product.setImageSrc("img_222");
        assertThat(product.getImageSrc()).isEqualTo("img_222");
    }

    public void whenCalledGetNameSource(){
        Product product = new Product("product-1", 12.0, "cool", "image_234");
        assertThat(product.getName()).isEqualTo("product-1");
    }

    public void whenCalledSetNameSource(){
        Product product = new Product("product-1", 12.0, "cool", "image_234");
        product.setName("pr_222");
        assertThat(product.getName()).isEqualTo("pr_222");
    }

    public void whenCalledGetDescriptionSource(){
        Product product = new Product("product-1", 12.0, "cool", "image_234");
        assertThat(product.getImageSrc()).isEqualTo("image_234");
    }

    public void whenCalledSetDescriptionSource(){
        Product product = new Product("product-1", 12.0, "cool", "image_234");
        product.setImageSrc("img_222");
        assertThat(product.getImageSrc()).isEqualTo("img_222");
    }

}
