package com.example.employee.service;

import java.util.List;

import com.example.employee.entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();

    public Employee save(Employee employee);

    public Employee findById(int id);

    public void deleteById(int id);
}
