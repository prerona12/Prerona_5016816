package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.projection.EmployeeProjection;
import com.example.employeemanagementsystem.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Interface-based projection
    List<EmployeeProjection> findAllProjectedBy();

    // Class-based projection using @Query
    @Query("SELECT new com.example.employeemanagementsystem.dto.EmployeeDTO(e.id, e.name, e.email, d.name) " +
           "FROM Employee e JOIN e.department d")
    List<EmployeeDTO> findAllEmployeeDTOs();
}

