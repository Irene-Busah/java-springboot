package com.example.employee.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.employee.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {

    private final EntityManager entityManager;

    public EmployeeDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implementing the function to find all employees
    @Override
    public List<Employee> findAll() {
        TypedQuery query = entityManager.createQuery("FROM Employee", Employee.class);

        // execute the query
        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee save(Employee employee) {

        Employee new_employee = entityManager.merge(employee);

        return new_employee;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);

        entityManager.remove(employee);
    }

}
