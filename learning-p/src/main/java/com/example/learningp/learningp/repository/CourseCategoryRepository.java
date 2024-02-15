package com.example.learningp.learningp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learningp.learningp.entity.Category;
import com.example.learningp.learningp.entity.CoursesCategory;


public interface CourseCategoryRepository extends JpaRepository<CoursesCategory, Long> {
    
	List<CoursesCategory> findByCategory(Category category);

}
