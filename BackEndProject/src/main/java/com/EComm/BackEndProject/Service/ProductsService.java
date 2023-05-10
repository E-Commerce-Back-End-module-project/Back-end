package com.EComm.BackEndProject.Service;

import com.EComm.BackEndProject.models.Products;
import com.EComm.BackEndProject.models.Category;
import com.EComm.BackEndProject.repositories.CategoryRepository;
import com.EComm.BackEndProject.repositories.ColorRepository;
import com.EComm.BackEndProject.repositories.ProductsRepository;
import com.EComm.BackEndProject.repositories.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ColorRepository colorRepository;
    @Autowired
    SizeRepository sizeRepository;
//    @GetMapping("category/{id_category}/products")
//    public ResponseEntity<List<Products>> getAllProductsByCategoryId(@PathVariable(value = "id_category") Long id_category){
//        List<Products> categoryProducts = productsRepository.findByCategoryId(id_category);
//        return  new ResponseEntity<>(categoryProducts, HttpStatus.OK);
//    }


}
