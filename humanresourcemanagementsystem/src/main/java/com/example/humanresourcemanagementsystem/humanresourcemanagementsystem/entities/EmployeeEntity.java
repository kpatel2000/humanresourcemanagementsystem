package com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String email;
    int age;
    String dateOfJoining;

    @JsonProperty("isActive")
    boolean isActive;
    double salary;

    @OneToOne
    DepartmentEntity managedDepartment;


}
