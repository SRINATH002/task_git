package com.Taskcrud.Taskspr.service;

import java.util.List;

import com.Taskcrud.Taskspr.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
	
}
