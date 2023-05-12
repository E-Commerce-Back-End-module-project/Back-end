package com.EComm.BackEndProject.Service;

import com.EComm.BackEndProject.models.Category;
import com.EComm.BackEndProject.models.Color;
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

    public Color saveAndFlush(Color colorRequest) {
        Color newColor = new Color();
        newColor.setName(colorRequest.getName());

        return colorRepository.saveAndFlush(newColor);
    }

    public Color getById(Long id_color) { return colorRepository.getReferenceById(id_color);
    }
}
