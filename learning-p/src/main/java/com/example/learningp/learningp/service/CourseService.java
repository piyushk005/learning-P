package com.example.learningp.learningp.service;

import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.learningp.learningp.Dto.CourseDto;
import com.example.learningp.learningp.Dto.GetCourseDto;
import com.example.learningp.learningp.entity.Category;
import com.example.learningp.learningp.entity.Courses;
import com.example.learningp.learningp.entity.CoursesCategory;
import com.example.learningp.learningp.mapper.CourseMapper;
import com.example.learningp.learningp.repository.CategoryRepository;
import com.example.learningp.learningp.repository.CourseCategoryRepository;
import com.example.learningp.learningp.repository.CourseRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CourseCategoryRepository coursesCategoryRepository;

	@Autowired
	private CourseMapper courseMapper;

	public boolean addCourse(CourseDto courseDto) {

		Optional<Category> categoryObj = categoryRepository.findByCategoryType(courseDto.getCategory());

		if (categoryObj.isEmpty()) {
			return false;
		}

		Category category = categoryObj.get();
		Courses course = courseMapper.courseDtoToCourses(courseDto);

		CoursesCategory obj = new CoursesCategory();
		obj.setCategory(category);
		obj.setCourse(courseRepository.save(course));
		coursesCategoryRepository.save(obj);

		log.info("Course added successfully: {}", course);
		return false;
	}

	public Optional<List<CoursesCategory>> getCourse(GetCourseDto getCourseDto) {
		Map<String, String> response = new HashMap<>();

		Optional<Category> categoryObject = categoryRepository.findByCategoryType(getCourseDto.getCategory());

		if (categoryObject.isEmpty()) {
			return Optional.of(null);
		}

		Category category = categoryObject.get();

		List<CoursesCategory> courses = coursesCategoryRepository.findByCategory(category);
		Optional<List<CoursesCategory>> optionalList = Optional.of(courses);
		log.info("Retrieved {} courses for category: {}", courses.size(), category.getCategoryType());
		return optionalList;
	}

	public ResponseEntity<?> getCourseId(Long id, GetCourseDto getCourseDto) {
		List<CoursesCategory> courses = getCourse(getCourseDto).get();

		for (CoursesCategory course : courses) {
			if (course.getId().equals(id)) {
				return new ResponseEntity<>(course, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(new HashMap<>().put("Message", "Course id doesn't exists"), HttpStatus.BAD_REQUEST);
	}
}

