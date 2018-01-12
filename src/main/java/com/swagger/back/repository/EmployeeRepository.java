package com.swagger.back.repository;

import com.swagger.back.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long>,JpaSpecificationExecutor<Employee>,CrudRepository<Employee,Long> {

    List<Employee> findByFirstNameIgnoreCaseContaining(@Param("firstName") String firstName);
    List<Employee> findByLastNameIgnoreCaseContaining(@Param("lastName") String lastName);

}
