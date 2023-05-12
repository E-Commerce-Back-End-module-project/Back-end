package com.EComm.BackEndProject.Service;

import com.EComm.BackEndProject.models.Category;
import com.EComm.BackEndProject.repositories.CategoryRepository;
import com.EComm.BackEndProject.repositories.ColorRepository;
import com.EComm.BackEndProject.repositories.ProductsRepository;
import com.EComm.BackEndProject.repositories.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    ColorRepository colorRepository;
    @Autowired
    SizeRepository sizeRepository;


    public Category saveAndFlush(Category categoryRequest) {
        Category newCategory = new Category();
        newCategory.setName(categoryRequest.getName());

        return categoryRepository.saveAndFlush(newCategory);
    }

    public Category getById(Long id_category) {
        return categoryRepository.getReferenceById(id_category);
    }
}
