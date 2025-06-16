package com.ibusah.course_rating_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ibusah.course_rating_system.dao.CourseRepository;
import com.ibusah.course_rating_system.dao.ReviewRepository;
import com.ibusah.course_rating_system.entity.Course;
import com.ibusah.course_rating_system.entity.Rating;

@Service
public class CourseRatingServiceImpl implements CourseService {

    public CourseRatingServiceImpl(CourseRepository courseRepository, ReviewRepository ratingRepository) {
        this.courseRepository = courseRepository;
        this.ratingRepository = ratingRepository;
    }

    private final CourseRepository courseRepository;
    private final ReviewRepository ratingRepository;

    @Override
    public List<Course> allCourses() {
        List<Course> courses = courseRepository.findAll();

        return courses;
    }

    @Override
    public Course findByCourse(int id) {
        Optional<Course> course = courseRepository.findById(id);

        Course results = null;
        if (course.isPresent()) {
            results = course.get();
        } else {
            throw new RuntimeException("Course Not Found");
        }

        return results;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public String deleteCourseById(int id) {
        courseRepository.deleteById(id);

        return "Course Deleted";
    }

    @Override
    public Rating addRating(int id, Rating rating) {
        Course course = findByCourse(id);

        rating.setCourse(course);
        return ratingRepository.save(rating);
    }

    @Override
    public double getAverageRating(int id) {
        List<Rating> ratings = ratingRepository.findByCourseId(id);

        return ratings.stream().mapToInt(Rating::getScore).average().orElse(0.0);
    }

}
