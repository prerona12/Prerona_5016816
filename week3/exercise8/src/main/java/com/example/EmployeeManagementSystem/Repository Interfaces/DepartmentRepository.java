package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Department;
import com.example.employeemanagementsystem.projection.DepartmentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Interface-based projection
    List<DepartmentProjection> findAllProjectedBy();

    // Custom query for projection
    @Query("SELECT d.id as id, d.name as name, SIZE(d.employees) as employeeCount " +
           "FROM Department d")
    List<DepartmentProjection> findDepartmentWithEmployeeCount();
}
