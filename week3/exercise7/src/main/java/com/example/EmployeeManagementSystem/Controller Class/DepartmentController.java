package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.model.Department;
import com.example.employeemanagementsystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Create a new Department
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    // Get all Departments
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Get a single Department by ID
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable(value = "id") Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
            .orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + departmentId));
        return ResponseEntity.ok().body(department);
    }

    // Update a Department
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable(value = "id") Long departmentId,
                                                       @RequestBody Department departmentDetails) {
        Department department = departmentRepository.findById(departmentId)
            .orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + departmentId));

        department.setName(departmentDetails.getName());

        final Department updatedDepartment = departmentRepository.save(department);
        return ResponseEntity.ok(updatedDepartment);
    }

    // Delete a Department
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable(value = "id") Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
            .orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + departmentId));

        departmentRepository.delete(department);
        return ResponseEntity.noContent().build();
    }
}
