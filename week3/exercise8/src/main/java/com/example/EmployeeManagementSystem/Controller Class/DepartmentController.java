

package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.projection.DepartmentProjection;
import com.example.employeemanagementsystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/projections")
    public List<DepartmentProjection> getDepartmentProjections() {
        return departmentRepository.findAllProjectedBy();
    }

    @GetMapping("/employeeCount")
    public List<DepartmentProjection> getDepartmentsWithEmployeeCount() {
        return departmentRepository.findDepartmentWithEmployeeCount();
    }
}
