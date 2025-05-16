package com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.controller;

import com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.dto.EmployeeDTO;
import com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/getEmployeeById/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO){
        return new ResponseEntity<>(employeeService.createEmployee(employeeDTO), HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee")
    ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestParam Long employeeId, @RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<>(employeeService.updateEmployeeById(employeeId, employeeDTO), HttpStatus.OK);
    }

    @PatchMapping("/updateEmployee")
    ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestParam Long employeeId, @RequestBody Map<String, Object> valuesToBeUpdated){
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, valuesToBeUpdated));
    }

    @DeleteMapping("/deleteEmployee/{employeeId}")
    String deleteEmployeeById(@PathVariable Long employeeId){
        return employeeService.deleteEmployeeById(employeeId);
    }

}
