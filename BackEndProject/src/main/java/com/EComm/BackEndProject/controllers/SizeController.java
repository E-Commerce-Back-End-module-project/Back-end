package com.EComm.BackEndProject.controllers;

import com.EComm.BackEndProject.Service.CategoryService;
import com.EComm.BackEndProject.Service.ColorService;
import com.EComm.BackEndProject.Service.ProductsService;
import com.EComm.BackEndProject.Service.SizeService;
import com.EComm.BackEndProject.models.Color;
import com.EComm.BackEndProject.models.Size;
import com.EComm.BackEndProject.repositories.CategoryRepository;
import com.EComm.BackEndProject.repositories.ProductsRepository;
import com.EComm.BackEndProject.repositories.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/size")
public class SizeController {
    @Autowired
    ColorService colorService;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    ProductsService productsService;
    @Autowired
    SizeRepository sizeRepository;
    @Autowired
    SizeService sizeService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Size> sizeList(){return sizeRepository.findAll();}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/{id}")
    public Size get(@PathVariable Long id) {
        return sizeRepository.getById(id);
    }

    //Create a new size
    @PostMapping
    public ResponseEntity<Size> create(@RequestBody Size size){
        Size newSize = sizeService.saveAndFlush(size);
        return new ResponseEntity<>(newSize, HttpStatus.CREATED);
    }



}
