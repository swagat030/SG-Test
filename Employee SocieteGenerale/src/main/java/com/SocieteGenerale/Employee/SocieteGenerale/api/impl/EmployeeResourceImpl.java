package com.SocieteGenerale.Employee.SocieteGenerale.api.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.SocieteGenerale.Employee.SocieteGenerale.api.EmployeeResource;
import com.SocieteGenerale.Employee.SocieteGenerale.model.Employee;
import com.SocieteGenerale.Employee.SocieteGenerale.service.EmployeeService;
import com.SocieteGenerale.Employee.SocieteGenerale.util.EmployeeException;
import com.SocieteGenerale.Employee.SocieteGenerale.util.ResourceNotFoundException;

/**
 * 
 * @author swagat
 *
 *         this resource will be used as controllers of Employee User Story details
 *         informations
 * 
 */

@RestController
public class EmployeeResourceImpl implements EmployeeResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeResourceImpl.class);
	
	@Autowired
	private EmployeeService employeeService;


	@Override
	public List<Employee> getAllEmployees() throws EmployeeException {
	    LOGGER.info("search getAllEmployees starts... ");
		return employeeService.findAll();
	}

	@Override
	public ResponseEntity<Employee> getEmployeeById(Long employeeId) throws EmployeeException {
		LOGGER.info("search getEmployeeById starts... ");
		Employee employee = employeeService.findById(employeeId)
				.orElseThrow(() -> new EmployeeException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	@Override
	public Employee createEmployee(@Valid Employee employee) throws EmployeeException {
		LOGGER.info("createEmployee starts... ");
		return employeeService.save(employee);
	}

	@Override
	public ResponseEntity<Employee> updateEmployee(Long employeeId, @Valid Employee employeeDetails)
			throws EmployeeException {
		LOGGER.info("updateEmployee starts... ");
		Employee employee = employeeService.findById(employeeId)
				.orElseThrow(() -> new EmployeeException("Employee not found for this id :: " + employeeId));

		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setGender(employeeDetails.getGender());
		employee.setDateOfBirth(employeeDetails.getDateOfBirth());
		employee.setDepartment(employeeDetails.getDepartment());
		final Employee updatedEmployee = employeeService.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@Override
	public Map<String, Boolean> deleteEmployee(Long employeeId) throws EmployeeException {
		LOGGER.info("deleteEmployee starts... ");
		Employee employee = employeeService.findById(employeeId)
				.orElseThrow(() -> new EmployeeException("Employee not found for this id :: " + employeeId));

		employeeService.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	
}
