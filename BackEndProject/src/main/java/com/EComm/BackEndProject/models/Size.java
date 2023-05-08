package com.EComm.BackEndProject.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_size;

    private String size;

//    @ManyToMany(mappedBy = "sizes")
//    @JsonIgnore
//
//    private List<Products> products;

    public Size(Long id_size, String size) {
        this.id_size = id_size;
        this.size = size;
    }

    public Size() {

    }

    public Long getId_size() {
        return id_size;
    }

    public void setId_size(Long id_size) {
        this.id_size = id_size;
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
