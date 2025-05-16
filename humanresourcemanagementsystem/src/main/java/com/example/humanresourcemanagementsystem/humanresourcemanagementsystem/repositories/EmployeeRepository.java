package com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.repositories;

import com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
