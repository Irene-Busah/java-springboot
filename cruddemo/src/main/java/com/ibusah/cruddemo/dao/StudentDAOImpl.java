package com.ibusah.cruddemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ibusah.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager entityManager;

    // defining the constructor
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // creating a query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName DESC", Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // create query
        TypedQuery<Student> thQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData",
                Student.class);

        thQuery.setParameter("theData", lastName);

        return thQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student newStudent) {
        // creating the query
        // TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ")
        entityManager.merge(newStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = entityManager.find(Student.class, id);

        entityManager.remove(student);
    }

}
