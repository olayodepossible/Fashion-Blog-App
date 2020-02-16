package com.possible.fashion.blog.model;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
public class CustomerComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String comment;

    @CreatedDate
    @CreationTimestamp
    private Date dateCreated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Customer customer;

    protected CustomerComment() {
    }

    public CustomerComment(String comment){
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDateCreated() {
        return dateCreated;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    @Override
    public String toString() {
        return "CustomerComment{" +
                "comment='" + comment + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
