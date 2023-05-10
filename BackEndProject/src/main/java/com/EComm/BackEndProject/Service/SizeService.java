package com.EComm.BackEndProject.Service;

import com.EComm.BackEndProject.models.Color;
import com.EComm.BackEndProject.models.Size;
import com.EComm.BackEndProject.repositories.CategoryRepository;
import com.EComm.BackEndProject.repositories.ColorRepository;
import com.EComm.BackEndProject.repositories.ProductsRepository;
import com.EComm.BackEndProject.repositories.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeService {
    @Autowired
    SizeRepository sizeRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    ColorRepository colorRepository;

    public Size saveAndFlush(Size sizeRequest) {
        Size newSize = new Size();
        newSize.setSize(sizeRequest.getSize());

        return sizeRepository.saveAndFlush(newSize);
    }
}
