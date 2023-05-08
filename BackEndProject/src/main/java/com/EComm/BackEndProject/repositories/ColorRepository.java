package com.EComm.BackEndProject.repositories;

import com.EComm.BackEndProject.models.Color;
import com.EComm.BackEndProject.models.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Long> {
}
