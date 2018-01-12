package com.swagger.controller;

import com.swagger.service.EmployeeService;
import flexjson.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resources;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

//    @Resources("EmployeeService")
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/findAllEmployee")
    public ResponseEntity<String> findAllEmployee(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json");

        return new ResponseEntity<>(new JSONSerializer()
                .prettyPrint(true).exclude("*.class").deepSerialize(employeeService.findAll())
                ,headers,HttpStatus.OK);
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<String> findOne(@PathVariable("id") Long id){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json");

        return new ResponseEntity<>(new JSONSerializer()
                .prettyPrint(true).exclude("*.class").deepSerialize(employeeService.findOne(id)),headers, HttpStatus.OK);
    }

    @GetMapping("/findByFirstName")
    public ResponseEntity<String> findByFirstName(@RequestParam("firstName") String firstName){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json");

        return new ResponseEntity<>(new JSONSerializer()
                .prettyPrint(true).exclude("*.class").deepSerialize(employeeService.findByFisrtName(firstName)),headers, HttpStatus.OK);
    }

    @GetMapping("/findByLastName")
    public ResponseEntity<String> findBylastName(@RequestParam("firstName") String lastName){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json");

        return new ResponseEntity<>(new JSONSerializer()
                .prettyPrint(true).exclude("*.class").deepSerialize(employeeService.findByLastName(lastName)),headers, HttpStatus.OK);
    }



}
