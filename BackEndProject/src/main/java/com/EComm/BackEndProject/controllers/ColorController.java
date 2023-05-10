package com.EComm.BackEndProject.controllers;

import com.EComm.BackEndProject.Service.CategoryService;
import com.EComm.BackEndProject.Service.ColorService;
import com.EComm.BackEndProject.Service.ProductsService;
import com.EComm.BackEndProject.Service.SizeService;
import com.EComm.BackEndProject.models.Category;
import com.EComm.BackEndProject.models.Color;
import com.EComm.BackEndProject.repositories.CategoryRepository;
import com.EComm.BackEndProject.repositories.ColorRepository;
import com.EComm.BackEndProject.repositories.ProductsRepository;
import com.EComm.BackEndProject.repositories.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/color")
public class ColorController {
    @Autowired
    ColorRepository colorRepository;

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
    public List<Color> colorList(){return colorRepository.findAll();}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/{id}")
    public Color get(@PathVariable Long id) {
        return colorRepository.getById(id);
    }

}
