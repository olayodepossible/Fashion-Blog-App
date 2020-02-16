package com.possible.fashion.blog.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3)
    @NotNull
    private String name;

    @Size(min = 13)
    @NotNull
    private String email;

    @CreationTimestamp
    @CreatedDate
    private Date createdAt;

    @OneToMany(mappedBy = "customer")
    private List<CustomerComment> comments;


    public Customer() {
    }

    public Customer(String name, String email){
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public List<CustomerComment> getComments() {
        return comments;
    }

    public void setComments(List<CustomerComment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
