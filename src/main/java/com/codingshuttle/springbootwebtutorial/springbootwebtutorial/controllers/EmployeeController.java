package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.controllers;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;

@RestController  // This annotations ensures that our controller mappings are REST-compliant. 
@RequestMapping(path="/employees") // This is the path of parent 
public class EmployeeController {

  /*   @GetMapping(path="/getSecretMessage")
    public String getMySuperSecretMessage(){
        return "I am awesome.";
    }

    */
    @GetMapping(path="/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id){

        return new EmployeeDTO(id, "Mayank", "mayank7860@gmail.com", 28, LocalDate.of(2024, 1, 02), true);


    }

    @GetMapping()
    public String getAllEmployees(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){

        return "Hi age "+ age + " sort by: "+ sortBy;


    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){

        inputEmployee.setId(100L);
        return inputEmployee;

    }

    @PutMapping String updateEmployeeById(){

        return "Hello from PUT";

    }
    
}
