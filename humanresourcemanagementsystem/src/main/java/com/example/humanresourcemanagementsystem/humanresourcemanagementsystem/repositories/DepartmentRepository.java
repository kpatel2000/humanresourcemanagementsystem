package com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.repositories;

import com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}
