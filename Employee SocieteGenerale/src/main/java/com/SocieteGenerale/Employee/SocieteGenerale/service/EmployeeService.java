package com.SocieteGenerale.Employee.SocieteGenerale.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SocieteGenerale.Employee.SocieteGenerale.model.Employee;


@Repository
public interface EmployeeService extends JpaRepository<Employee, Long>{

}
