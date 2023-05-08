package com.EComm.BackEndProject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity(name = "Products")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Products")
public class Products {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProducts;

    @Column(name = "Name")
    private String name;

    @Column(name = "Price")
    private Double price;

    @Column(name = "Description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategory")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Category category;

        public Products(Long idProducts, String name, Double price, String description, Category category) {
        this.idProducts = idProducts;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }
    public Products(){

    }
    public Long getIdProducts() {
        return idProducts;
    }

    public void setIdProducts(Long idProducts) {
        this.idProducts = idProducts;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
