package com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.services;

import com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);

    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO assignmentDepartmentToEmployee(Long departmentId, Long employeeId);
}
