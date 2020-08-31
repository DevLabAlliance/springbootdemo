/**
 * 
 */
package com.devlabsalliance.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devlabsalliance.rest.entity.Employee;

/**
 * @author sachin
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
