package com.example.learningp.learningp.controller;



import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learningp.learningp.Dto.CategoryDto;
import com.example.learningp.learningp.entity.Category;
import com.example.learningp.learningp.service.CategoryService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@PostMapping("/create")
	public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		boolean add = categoryService.addCategory(categoryDto);
		HashMap<String, String> response = new HashMap<>();

		if (add) {
			response.put("Message", "Category Added.");
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} else {
			response.put("Message", "Something went wrong");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllCategory() {
		HashMap<String, List<Category>> response = new HashMap<>();
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
}
