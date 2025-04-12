package com.ibusah.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibusah.demo.entity.Student;
import com.ibusah.demo.entity.studentExceptionHandling;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StrudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {
        /**
         * runs only once to load sample data
         * 
         * @return
         */

        students = new ArrayList<>();

        students.add(new Student("Irene", "Busah"));
        students.add(new Student("Mike", "Kip"));
        students.add(new Student("Emmanuel", "Junior"));
        students.add(new Student("Nelson", "Nor"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if (studentId < 0 || studentId >= students.size()) {
            throw new studentExceptionHandling("Student ID not found - " + studentId);
        }

        return students.get(studentId);

    }
}
