package com.EComm.BackEndProject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColor;

    @Column(name = "Color")
    private String color;

    @ManyToMany(mappedBy = "colors")
    @JsonIgnore

    private List<Products> products;

    public Color(){

    }

    public Long getIdColor() {
        return idColor;
    }

    public void setIdColor(Long idColor) {
        this.idColor = idColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}
