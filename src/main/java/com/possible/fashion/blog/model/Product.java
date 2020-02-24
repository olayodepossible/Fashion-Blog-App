package com.possible.fashion.blog.model;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String imageSrc;

    @NotNull
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private String description;

    @CreationTimestamp
    @CreatedDate
    private Date createdAt;

/*    @OneToMany(mappedBy = "product")
    private List<Comment> commentList = new ArrayList<>();*/

    public Product() {
    }

    public Product(String name, Double price, String description, String imageSrc){
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageSrc = imageSrc;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
/*
    public void addComment(Comment post){
        commentList.add(post);
        post.setProduct(this);
    }
    public void removeComment(Comment post){
        commentList.remove(post);
        post.setProduct(null);
    }*/

    /*public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }*/

    @Override
    public String toString() {
        return "Product{" +
                "imageSrc='" + imageSrc + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

