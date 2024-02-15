package com.example.learningp.learningp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learningp.learningp.entity.Courses;


public interface CourseRepository extends JpaRepository<Courses, Long> {

}
