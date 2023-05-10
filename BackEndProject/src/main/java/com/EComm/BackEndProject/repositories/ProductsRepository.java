package com.EComm.BackEndProject.repositories;

import com.EComm.BackEndProject.models.Products;
import com.EComm.BackEndProject.models.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

//    List<Products> findByCategoryId(Long id_Category);
}
