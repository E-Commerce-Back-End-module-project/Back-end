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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Products")
    private Long id_Products;

    @Column(name = "Name")
    private String name;

    @Column(name = "Price")
    private Double price;

    @Column(name = "Description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_category")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

        public Products(Long id_Products, String name, Double price, String description, Category category) {
        this.id_Products = id_Products;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public Products(Long id_Products, String name, Double price, String description, Category category,
                    List<Color> colors, List<Size> sizes) {
        this.id_Products = id_Products;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.colors = colors;
        this.sizes = sizes;
    }

    @ManyToMany
    @JoinTable(
            name = "products_color",
            joinColumns = @JoinColumn(name = "id_products"),
            inverseJoinColumns = @JoinColumn(name = "id_color")
    )
    private List<Color> colors;

    @ManyToMany
    @JoinTable(
            name = "products_size",
            joinColumns = @JoinColumn(name = "id_products"),
            inverseJoinColumns = @JoinColumn(name = "id_size")
    )
    private List<Size> sizes;
    public Products(){

    }
    public Long getId_Products() {
        return id_Products;
    }

    public void setId_Products(Long id_Products) {
        this.id_Products = id_Products;
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

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }
}
