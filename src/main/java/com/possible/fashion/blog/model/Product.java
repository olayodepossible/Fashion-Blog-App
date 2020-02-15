package com.possible.fashion.blog.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String imageSrc;

    @CreationTimestamp
    @CreatedDate
    private java.sql.Timestamp createdAt;

    @OneToMany(mappedBy = "product")
    private List<CustomerComment> comments;

    protected Product() {
    }

    public Product(String imageSrc){
        this.imageSrc = imageSrc;
    }

    public Long getId() {
        return id;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public List<CustomerComment> getComments() {
        return comments;
    }

    public void setComments(List<CustomerComment> comments) {
        this.comments = comments;
    }

}
