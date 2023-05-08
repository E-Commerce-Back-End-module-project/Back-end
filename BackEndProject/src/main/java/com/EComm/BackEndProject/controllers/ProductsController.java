package com.EComm.BackEndProject.controllers;

import com.EComm.BackEndProject.models.Products;
import com.EComm.BackEndProject.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductsController {
    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Products> list() {return productsRepository.findAll();}
}
