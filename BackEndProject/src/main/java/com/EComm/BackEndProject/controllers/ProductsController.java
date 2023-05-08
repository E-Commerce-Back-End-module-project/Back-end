package com.EComm.BackEndProject.controllers;

import com.EComm.BackEndProject.models.Products;
import com.EComm.BackEndProject.repositories.CategoryRepository;
import com.EComm.BackEndProject.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductsController {
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Products> list() {return productsRepository.findAll();}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("products/{id}")
    public Products get(@PathVariable Long id) {
        return productsRepository.getById(id);
    }
}


