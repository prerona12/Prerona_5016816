package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void batchInsertEmployees(List<Employee> employees) {
        for (int i = 0; i < employees.size(); i++) {
            employeeRepository.save(employees.get(i));
            if (i % 20 == 0) { // Flush after every 20 inserts
                employeeRepository.flush();
            }
        }
    }
}

