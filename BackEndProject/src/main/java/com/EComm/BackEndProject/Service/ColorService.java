package com.EComm.BackEndProject.Service;

import com.EComm.BackEndProject.repositories.CategoryRepository;
import com.EComm.BackEndProject.repositories.ColorRepository;
import com.EComm.BackEndProject.repositories.ProductsRepository;
import com.EComm.BackEndProject.repositories.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorService {
    @Autowired
    ColorRepository colorRepository;
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    SizeRepository sizeRepository;
}
