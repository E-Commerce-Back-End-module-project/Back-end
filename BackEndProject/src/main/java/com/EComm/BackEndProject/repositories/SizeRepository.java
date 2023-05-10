package com.EComm.BackEndProject.repositories;

import com.EComm.BackEndProject.models.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {

}
