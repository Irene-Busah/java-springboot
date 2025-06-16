package com.ibusah.course_rating_system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibusah.course_rating_system.entity.Rating;

public interface ReviewRepository extends JpaRepository<Rating, Integer> {
    List<Rating> findByCourseId(int id);

}
