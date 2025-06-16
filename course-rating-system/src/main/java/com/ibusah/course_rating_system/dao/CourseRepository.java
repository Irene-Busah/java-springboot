package com.ibusah.course_rating_system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibusah.course_rating_system.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
