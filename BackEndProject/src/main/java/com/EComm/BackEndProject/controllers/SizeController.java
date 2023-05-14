package com.EComm.BackEndProject.controllers;

import com.EComm.BackEndProject.Service.CategoryService;
import com.EComm.BackEndProject.Service.ColorService;
import com.EComm.BackEndProject.Service.ProductsService;
import com.EComm.BackEndProject.Service.SizeService;
import com.EComm.BackEndProject.exception.ResourceNotFoundException;
import com.EComm.BackEndProject.models.Color;
import com.EComm.BackEndProject.models.Size;
import com.EComm.BackEndProject.repositories.CategoryRepository;
import com.EComm.BackEndProject.repositories.ProductsRepository;
import com.EComm.BackEndProject.repositories.SizeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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
    @RequestMapping("/{id}")
    public Object get(@PathVariable Long id) {
        try{
            Size size = sizeService.getById(id);
            return new ResponseEntity<Size>(size, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //Create a new size
    @PostMapping
    public ResponseEntity<Size> create(@RequestBody Size size){
        Size newSize = sizeService.saveAndFlush(size);
        return new ResponseEntity<>(newSize, HttpStatus.CREATED);
    }

    // Delete a size
    @DeleteMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteColorById(@PathVariable("id") Long id_size) {
        sizeRepository.deleteById(id_size);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    //Update a Size
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Size update(@PathVariable("id") Long id_size, @RequestBody Size size) {
        Size updatedSize = sizeRepository.findById(id_size)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Not found Size with id = " + id_size));

        BeanUtils.copyProperties(size, updatedSize, "id_size");
        return sizeRepository.saveAndFlush(updatedSize);
    }



}
