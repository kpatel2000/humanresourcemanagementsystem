package com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.controller;

import com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.dto.DepartmentDTO;
import com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.services.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/createDepartment")
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody @Valid DepartmentDTO departmentDTO){
        return new ResponseEntity<>(departmentService.createDepartment(departmentDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getDepartments")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments(){
        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    @PostMapping("/assignDepartmentToEmployee/{departmentId}/{employeeId}")
    public ResponseEntity<DepartmentDTO> assignmentDepartmentToEmployee(@PathVariable Long departmentId, @PathVariable Long employeeId){
        return new ResponseEntity<>(departmentService.assignmentDepartmentToEmployee(departmentId, employeeId), HttpStatus.OK);
    }
}
