package com.devlabsalliance.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devlabsalliance.rest.entity.Employee;
import com.devlabsalliance.rest.model.EmployeeTO;
import com.devlabsalliance.rest.service.EmployeeService;

@RestController
public class EmployeeController 
{
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping(path="/employees/{employeeId}", produces = "application/json")
    public @ResponseBody Employee getEmployees(@PathVariable("employeeId") Integer employeeId) 
    {
//    	Employee employee = new Employee();
//    	employee.setId(employeeId);
//    	employee.setFirstName("Sachin");
//    	employee.setLastName("Kakkar");
//    	employee.setEmail("sachinkakar@gmail.com");
    	Employee employee = employeeService.getEmployee(employeeId);
		return employee;
    	
    }
    
    @PostMapping(path= "/employees", consumes = "application/json", produces = "application/json")
    public @ResponseBody Employee Employee(@RequestBody EmployeeTO newEmployee){       
        Employee employeeToSave = new Employee();
        employeeToSave.setFirstName(newEmployee.getFirstName());
        employeeToSave.setLastName(newEmployee.getLastName());
        employeeToSave.setEmail(newEmployee.getEmail());
        
        return employeeService.createEmployee(employeeToSave);
    }
}
