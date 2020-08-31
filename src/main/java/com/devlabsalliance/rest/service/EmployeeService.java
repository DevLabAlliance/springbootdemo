/**
 * 
 */
package com.devlabsalliance.rest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devlabsalliance.rest.entity.Employee;
import com.devlabsalliance.rest.repository.EmployeeRepository;

/**
 * @author sachin
 *
 */
@Service
public class EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Employee getEmployee(Integer employeeId) throws RuntimeException {
		Optional<Employee> retrieveEmployee = employeeRepository.findById(employeeId);
		if(!retrieveEmployee.isPresent()) {
			throw new RuntimeException("Employee Not Found");
		}
		return retrieveEmployee.get();
	}
	
	public Employee createEmployee(Employee employeeToSave) {
		return employeeRepository.save(employeeToSave);
	}
}
