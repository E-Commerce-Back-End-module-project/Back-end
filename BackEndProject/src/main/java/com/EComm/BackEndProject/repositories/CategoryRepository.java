package com.EComm.BackEndProject.repositories;

import com.EComm.BackEndProject.models.Category;
import com.EComm.BackEndProject.models.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
