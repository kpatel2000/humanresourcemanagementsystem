package com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.services;

import com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.dto.EmployeeDTO;

import java.util.List;
import java.util.Map;


public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long employeeId);

    EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployeeById(Long employeeId, Map<String, Object> valuesToBeUpdated);

    String deleteEmployeeById(Long employeeId);
}
