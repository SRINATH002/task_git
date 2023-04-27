package com.Taskcrud.Taskspr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Taskcrud.Taskspr.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
