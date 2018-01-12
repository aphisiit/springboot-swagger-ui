package com.swagger.back.controller;

import com.swagger.back.service.EmployeeService;
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

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/findAllEmployee",produces = "text/html; charset=utf-8",headers = "Accept=application/json; charset=utf-8")
    public ResponseEntity<String> findAllEmployee(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json");

        return new ResponseEntity<>(new JSONSerializer()
                .prettyPrint(true).exclude("*.class").deepSerialize(employeeService.findAll())
                ,headers,HttpStatus.OK);
    }

    @GetMapping(value = "/findOne/{id}",produces = "text/html; charset=utf-8",headers = "Accept=application/json; charset=utf-8")
    public ResponseEntity<String> findOne(@PathVariable("id") Long id){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json");

        return new ResponseEntity<>(new JSONSerializer()
                .prettyPrint(true).exclude("*.class").deepSerialize(employeeService.findOne(id)),headers, HttpStatus.OK);
    }

    @GetMapping(value = "/findByFirstName",produces = "text/html; charset=utf-8",headers = "Accept=application/json; charset=utf-8")
    public ResponseEntity<String> findByFirstName(@RequestParam("firstName") String firstName){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json");

        return new ResponseEntity<>(new JSONSerializer()
                .prettyPrint(true).exclude("*.class").deepSerialize(employeeService.findByFisrtName(firstName)),headers, HttpStatus.OK);
    }

    @GetMapping(value = "/findByLastName",produces = "text/html; charset=utf-8",headers = "Accept=application/json; charset=utf-8")
    public ResponseEntity<String> findBylastName(@RequestParam("lastName") String lastName){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json");

        return new ResponseEntity<>(new JSONSerializer()
                .prettyPrint(true).exclude("*.class").deepSerialize(employeeService.findByLastName(lastName)),headers, HttpStatus.OK);
    }



}
