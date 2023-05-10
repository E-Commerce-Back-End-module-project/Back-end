package com.EComm.BackEndProject.controllers;

import com.EComm.BackEndProject.Service.CategoryService;
import com.EComm.BackEndProject.Service.ProductsService;
import com.EComm.BackEndProject.models.Category;
import com.EComm.BackEndProject.repositories.CategoryRepository;
import com.EComm.BackEndProject.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    ProductsService productsService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Category> categoryList(){return categoryRepository.findAll();}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/{id}")
    public Category get(@PathVariable Long id) {
        return categoryRepository.getById(id);
    }





}
