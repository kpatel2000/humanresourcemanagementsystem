package com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.services.impl;

import com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.dto.DepartmentDTO;
import com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.entities.DepartmentEntity;
import com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.entities.EmployeeEntity;
import com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.repositories.DepartmentRepository;
import com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.repositories.EmployeeRepository;
import com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final ModelMapper modelMapper;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        DepartmentEntity entity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        DepartmentEntity savedDepartment = departmentRepository.save(entity);
        return modelMapper.map(savedDepartment, DepartmentDTO.class);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository
                .findAll()
                .stream()
                .map(department-> modelMapper.map(department, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO assignmentDepartmentToEmployee(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> department = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employee = employeeRepository.findById(employeeId);

        return department.flatMap(departmentEntity->
            employee.map(employeeEntity-> {
                departmentEntity.setManager(employeeEntity);
                return modelMapper.map(departmentRepository.save(departmentEntity), DepartmentDTO.class);
            })).orElse(null);
    }
}
