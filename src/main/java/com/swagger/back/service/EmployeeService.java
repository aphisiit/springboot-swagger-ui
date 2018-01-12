package com.swagger.back.service;

import com.swagger.back.domain.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findOne(Long id);
    List<Employee> findByFisrtName(String firstName);
    List<Employee> findByLastName(String lastName);
}
