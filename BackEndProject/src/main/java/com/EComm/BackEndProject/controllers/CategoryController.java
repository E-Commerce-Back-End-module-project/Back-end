package com.EComm.BackEndProject.controllers;

import com.EComm.BackEndProject.Service.CategoryService;
import com.EComm.BackEndProject.Service.ProductsService;
import com.EComm.BackEndProject.exception.ResourceNotFoundException;
import com.EComm.BackEndProject.models.Category;
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
    @RequestMapping("/{id}")
    public Object get(@PathVariable Long id) {
        try{
            Category category = categoryService.getById(id);
            return new ResponseEntity<Category>(category,HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
    }

    //Create a new category
    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category){
        Category newCategory = categoryService.saveAndFlush(category);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    // Delete a category
    @DeleteMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteCategoryById(@PathVariable("id") Long id_category) {
        categoryRepository.deleteById(id_category);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    //Update a Category
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Category update(@PathVariable("id") Long id_Category, @RequestBody Category category) {
        Category updatedCategory = categoryRepository.findById(id_Category)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Not found Category with id = " + id_Category));

        BeanUtils.copyProperties(category, updatedCategory, "id_Category");
        return categoryRepository.saveAndFlush(updatedCategory);
    }


}
