package com.example.employee.dao;

import java.util.List;

import com.example.employee.entity.Employee;

public interface EmployeeDAO {

    // retrieving all employees
    List<Employee> findAll();

    // retrieves an employee by ID
    public Employee findById(int id);

    // save or update an employee
    public Employee save(Employee employee);

    // deletes an employee from the system
    public void deleteById(int id);

}
