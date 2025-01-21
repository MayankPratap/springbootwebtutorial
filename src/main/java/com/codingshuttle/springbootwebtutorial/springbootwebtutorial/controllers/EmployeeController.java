package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepository;

@RestController  // This annotations ensures that our controller mappings are REST-compliant. 
@RequestMapping(path="/employees") // This is the path of parent 
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository){

        this.employeeRepository = employeeRepository;

    }

  /*   @GetMapping(path="/getSecretMessage")
    public String getMySuperSecretMessage(){
        return "I am awesome.";
    }

    */
    @GetMapping(path="/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id){

       // return new EmployeeDTO(id, "Mayank", "mayank7860@gmail.com", 28, LocalDate.of(2024, 1, 02), true);
       return employeeRepository.findById(id).orElse(null);

    }

    @GetMapping()
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){

       // return "Hi age "+ age + " sort by: "+ sortBy;
        return employeeRepository.findAll();

    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){

       // inputEmployee.setId(100L);
       // return inputEmployee;
       return employeeRepository.save(inputEmployee);

    }

    @PutMapping String updateEmployeeById(){

        return "Hello from PUT";

    }
    
}
