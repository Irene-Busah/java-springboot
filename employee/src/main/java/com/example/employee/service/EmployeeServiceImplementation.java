package com.example.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employee.dao.EmployeeDAO;
import com.example.employee.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImplementation(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeDAO.findAll();

        return employees;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }

}
