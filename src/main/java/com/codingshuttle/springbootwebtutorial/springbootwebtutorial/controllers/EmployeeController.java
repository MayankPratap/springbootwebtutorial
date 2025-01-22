package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity; 
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.services.EmployeeService;

@RestController  // This annotations ensures that our controller mappings are REST-compliant. 
@RequestMapping(path="/employees") // This is the path of parent 
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){

        this.employeeService = employeeService;

    }

  /*   @GetMapping(path="/getSecretMessage")
    public String getMySuperSecretMessage(){
        return "I am awesome.";
    }

    */
    @GetMapping(path="/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id){

       // return new EmployeeDTO(id, "Mayank", "mayank7860@gmail.com", 28, LocalDate.of(2024, 1, 02), true);
       return employeeService.getEmployeeById(id);

    }

    @GetMapping()
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){

       // return "Hi age "+ age + " sort by: "+ sortBy;
        return employeeService.getAllEmployees();

    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){

       // inputEmployee.setId(100L);
       // return inputEmployee;
       return employeeService.createNewEmployee(inputEmployee);

    }

    @PutMapping(path="/{employeeId}")
    public EmployeeDTO updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId){

        return employeeService.updateEmployeeById(employeeId, employeeDTO);

    }

    @DeleteMapping(path = "/{employeeId}")
    public boolean deleteEmployeeById(@PathVariable Long employeeId){

           return employeeService.deleteEmployeeById(employeeId);

    }
    
}
