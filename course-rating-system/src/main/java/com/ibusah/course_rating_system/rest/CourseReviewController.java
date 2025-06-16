package com.ibusah.course_rating_system.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibusah.course_rating_system.entity.Course;
import com.ibusah.course_rating_system.entity.Rating;
import com.ibusah.course_rating_system.service.CourseService;

@RestController
@RequestMapping("/api/")
public class CourseReviewController {
    private final CourseService courseService;

    public CourseReviewController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.allCourses();
    }

    @GetMapping("/courses/{id}/course")
    public Course getCourse(@PathVariable int id) {
        Course course = courseService.findByCourse(id);

        return course;
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        // course.setId(0);

        return courseService.saveCourse(course);
    }

    @PostMapping("/courses/{courseId}/ratings")
    public ResponseEntity<?> addRating(@PathVariable int courseId, @RequestBody Rating rating) {
        // Manual validation
        if (rating.getScore() < 1 || rating.getScore() > 5) {
            return ResponseEntity
                    .badRequest()
                    .body("Score must be between 1 and 5");
        }

        Rating savedRating = courseService.addRating(courseId, rating);
        return ResponseEntity.ok(savedRating);
    }

}
