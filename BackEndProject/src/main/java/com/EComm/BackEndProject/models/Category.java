package com.EComm.BackEndProject.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "Category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_category;

    private String name;

    public Category(Long id_category, String name) {
        this.id_category = id_category;
        this.name = name;
    }

    public Category(){

    }

    public Long getId_category() {
        return id_category;
    }

    public void setId_category(Long id_category) {
        this.id_category = id_category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
