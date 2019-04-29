package com.SocieteGenerale.Employee.SocieteGenerale.api;



import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SocieteGenerale.Employee.SocieteGenerale.config.ResourceConstants;
import com.SocieteGenerale.Employee.SocieteGenerale.model.Employee;
import com.SocieteGenerale.Employee.SocieteGenerale.util.EmployeeException;


@RequestMapping(ResourceConstants.SERVICE_ROOT_URI + ResourceConstants.SERVICE_VERSION_URI)
public interface EmployeeResource extends EmployeeBaseResource {
	
	@GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployees() throws EmployeeException;
	
	@GetMapping(value="/employees/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws EmployeeException;
    
    @PostMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee createEmployee(@Valid @RequestBody Employee employee) throws EmployeeException;
    
    
    @PutMapping(value = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Employee employeeDetails) throws EmployeeException;
	
	@DeleteMapping(value="/employees/{id}", produces=MediaType.APPLICATION_JSON_VALUE )
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws EmployeeException  ;

    
}
