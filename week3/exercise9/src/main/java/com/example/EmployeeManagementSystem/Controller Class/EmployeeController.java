package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.projection.EmployeeProjection;
import com.example.employeemanagementsystem.dto.EmployeeDTO;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/projections")
    public List<EmployeeProjection> getEmployeeProjections() {
        return employeeRepository.findAllProjectedBy();
    }

    @GetMapping("/dto")
    public List<EmployeeDTO> getEmployeeDTOs() {
        return employeeRepository.findAllEmployeeDTOs();
    }
}

