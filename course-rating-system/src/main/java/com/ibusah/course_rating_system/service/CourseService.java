package com.ibusah.course_rating_system.service;

import java.util.List;

import com.ibusah.course_rating_system.entity.Course;
import com.ibusah.course_rating_system.entity.Rating;

public interface CourseService {
    List<Course> allCourses();

    Course findByCourse(int id);

    Course saveCourse(Course course);

    String deleteCourseById(int id);

    Rating addRating(int id, Rating rating);

    double getAverageRating(int id);

}
