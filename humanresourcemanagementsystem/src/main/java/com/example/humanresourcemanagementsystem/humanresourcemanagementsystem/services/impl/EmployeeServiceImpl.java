package com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.services.impl;

import com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.dto.EmployeeDTO;
import com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.entities.EmployeeEntity;
import com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.exceptions.ResourceNotFoundException;
import com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.repositories.EmployeeRepository;
import com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final ModelMapper modelMapper;
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        return employees
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        EmployeeEntity employeeEntity = getEmployee(employeeId);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    private EmployeeEntity getEmployee(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));
    }

    @Override
    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = getEmployee(employeeId);
        if (employeeEntity != null) {
            employeeEntity.setId(employeeId);
            employeeRepository.save(employeeEntity);
            return modelMapper.map(employeeEntity, EmployeeDTO.class);
        } else {
            EmployeeEntity newEmployee = modelMapper.map(employeeDTO, EmployeeEntity.class);
            newEmployee.setId(employeeId);
            employeeRepository.save(newEmployee);
            return modelMapper.map(newEmployee, EmployeeDTO.class);
        }
    }

    @Override
    public EmployeeDTO updateEmployeeById(Long employeeId, Map<String, Object> valuesToBeUpdated) {
        EmployeeEntity employeeEntity = getEmployee(employeeId);

        if (employeeEntity != null) {
            valuesToBeUpdated.forEach((field, value) -> {
                Field fieldToBeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class, field);
                fieldToBeUpdated.setAccessible(true);
                ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
            });
            employeeRepository.save(employeeEntity);
            return modelMapper.map(employeeEntity, EmployeeDTO.class);
        }
        return null;
    }

    @Override
    public String deleteEmployeeById(Long employeeId) {
        EmployeeEntity employeeEntity = getEmployee(employeeId);
        if (employeeEntity != null) {
            employeeRepository.delete(employeeEntity);
            return "Employee deleted successfully";
        } else {
            return "No employee found!";
        }
    }
}
