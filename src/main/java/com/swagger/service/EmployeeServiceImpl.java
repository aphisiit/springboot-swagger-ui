package com.swagger.service;

import com.swagger.domain.Employee;
import com.swagger.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Employee> findByFisrtName(String firstName) {
        return repository.findByFirstNameIgnoreCaseContaining(firstName);
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        return repository.findByLastNameIgnoreCaseContaining(lastName);
    }
}
