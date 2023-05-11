package com.EComm.BackEndProject.controllers;

import com.EComm.BackEndProject.Service.CategoryService;
import com.EComm.BackEndProject.Service.ProductsService;
import com.EComm.BackEndProject.exception.ResourceNotFoundException;
import com.EComm.BackEndProject.models.Category;
import com.EComm.BackEndProject.models.Color;
import com.EComm.BackEndProject.models.Products;
import com.EComm.BackEndProject.repositories.CategoryRepository;
import com.EComm.BackEndProject.repositories.ProductsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

import static org.checkerframework.checker.nullness.Opt.orElseThrow;

@RestController
@RequestMapping("/")
public class ProductsController {
    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    ProductsService productsService;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryService categoryService;


//    Get all products
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Products> list() {return productsRepository.findAll();}

    //get Product by id
    @GetMapping
    @RequestMapping("products/{id}")
    public ResponseEntity<Products> get(@PathVariable Long id) {
        try {
            Products products = productsRepository.getById(id);
            return new ResponseEntity<Products>(products, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Products>(HttpStatus.NOT_FOUND);
        }

    }

//get a list of products in a category
//    @GetMapping("category/{id_category}/products")
//    public ResponseEntity<List<Products>> getAllProductsByCategoryId(@PathVariable(value = "id_category") Long id_category){
//        List<Products> categoryProducts = productsRepository.findByCategoryId(id_category);
//        return  new ResponseEntity<>(categoryProducts, HttpStatus.OK);
//    }

    // Create a new product
    @PostMapping
    @RequestMapping("products")
    public ResponseEntity<Products> create(@RequestBody Products products){
           Products product = productsService.saveAndFlush(products);
           return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
// Delete a product
    @DeleteMapping
    @RequestMapping(value = "products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id_Products) {
        productsRepository.deleteById(id_Products);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

//Update a Product
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "products/{id}", method = RequestMethod.PUT)
    public Products update(@PathVariable("id") Long id_Products, @RequestBody Products products) {
        Products product = productsRepository.findById(id_Products)
             .orElseThrow(() -> new ResourceNotFoundException("Not found Product with id = " + id_Products));

        BeanUtils.copyProperties(products, product, "id_Products");
        return productsRepository.saveAndFlush(product);


    }




}


