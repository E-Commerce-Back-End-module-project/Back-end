package com.EComm.BackEndProject.repositories;

import com.EComm.BackEndProject.models.Category;
import com.EComm.BackEndProject.models.Products;
import com.EComm.BackEndProject.models.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}


