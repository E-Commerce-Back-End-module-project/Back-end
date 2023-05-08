package com.EComm.BackEndProject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSize;

    private String size;

//    @ManyToMany(mappedBy = "sizes")
//    @JsonIgnore
//
//    private List<Products> products;

    public Size(Long idSize, String size) {
        this.idSize = idSize;
        this.size = size;
    }

    public Size() {

    }

    public Long getIdSize() {
        return idSize;
    }

    public void setIdSize(Long idSize) {
        this.idSize = idSize;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

//    public List<Products> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Products> products) {
//        this.products = products;
//    }
}
