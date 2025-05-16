package com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    int age;

    @JsonProperty("isActive")
    Boolean isActive;

    @OneToOne(mappedBy = "managedDepartment")
    @JoinColumn(name = "department_manager")
    EmployeeEntity manager;

    @CreationTimestamp
    LocalDate createdAt;
}
