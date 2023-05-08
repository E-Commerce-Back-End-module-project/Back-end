package com.EComm.BackEndProject.repositories;

import com.EComm.BackEndProject.models.Products;
import com.EComm.BackEndProject.models.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long> {
}
