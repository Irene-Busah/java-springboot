package com.ibusah.course_rating_system.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Rating> ratings = new ArrayList<>();

    public Course() {
    }

    public Course(String title, List<Rating> ratings) {
        this.title = title;
        this.ratings = ratings;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

}
