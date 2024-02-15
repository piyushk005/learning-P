package com.example.learningp.learningp.mapper;

import org.mapstruct.Mapper;

import com.example.learningp.learningp.Dto.CategoryDto;
import com.example.learningp.learningp.Dto.CourseDto;
import com.example.learningp.learningp.entity.Category;
import com.example.learningp.learningp.entity.Courses;



@Mapper(componentModel = "spring")
public interface CourseMapper {
   
	Category categoryDtoToCategory(CategoryDto categoryDto);
	
	Courses courseDtoToCourses(CourseDto courseDto);
	
	Category typeToCategory(String type);
	
	CategoryDto categoryToCategoryDto(Category category);
}
