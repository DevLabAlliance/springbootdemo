/**
 * 
 */
package com.devlabsalliance.rest.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.devlabsalliance.rest.entity.Employee;
import com.devlabsalliance.rest.service.EmployeeService;


/**
 * @author sachin
 *
 */ 
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmployeeControllerTest {
	
	@Autowired
	private EmployeeController employeeController;
	@MockBean private EmployeeService employeeService;
	
	@Test
	public void getEmployee() {
		
		Employee employee = new Employee();
		employee.setId(1);
		employee.setFirstName("sachin");
		employee.setLastName("kakkar");
		employee.setEmail("sachinkakar@gmail.com");
		
		Mockito.doReturn(employee).when(employeeService).getEmployee(1);
		
		Employee emp = employeeController.getEmployees(1);
		
		assertThat(emp.getId()).isEqualTo(employee.getId());
		
	}

}
