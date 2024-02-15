package com.example.learningp.learningp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "courses")
public class Courses {
	
	
	   
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(name = "course_name")
		private String courseName;
		
		@Column(name = "author")
		private String authorID;
		
	}


