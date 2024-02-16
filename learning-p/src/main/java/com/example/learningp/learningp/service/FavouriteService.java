package com.example.learningp.learningp.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.learningp.learningp.Dto.FavouriteDto;
import com.example.learningp.learningp.entity.Courses;
import com.example.learningp.learningp.entity.User;
import com.example.learningp.learningp.repository.CourseRepository;
import com.example.learningp.learningp.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FavouriteService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private UserRepository userRepository;

	public boolean makeFavourite(FavouriteDto favouriteDto) {

		Optional<Courses> course = courseRepository.findById(favouriteDto.getCourseId());
		String email = favouriteDto.getEmail();
		User user = userRepository.findByEmail(email);

		if (user == null || course.isEmpty()) {
			log.error("Failed to add course to favourites. Validation error.");
			return false;
		}

		Set<Courses> favourite = user.getFavourites();
		favourite.add(course.get());
		user.setFavourites(favourite);
		userRepository.save(user);

		log.info("Course added to favourites. CourseId: {}, User: {}", favouriteDto.getCourseId(), email);
		return true;
	}

	public boolean removeFavourite(FavouriteDto favouriteDto) {

		Optional<Courses> course = courseRepository.findById(favouriteDto.getCourseId());
		String email = favouriteDto.getEmail();
		User user = userRepository.findByEmail(email);

		if (user == null || course.isEmpty()) {
			log.info("Course added to favourites. CourseId: {}, User: {}", favouriteDto.getCourseId(), email);
			return false;
		}

		Set<Courses> favourite = user.getFavourites();

		try {
			favourite.remove(course.get());
			log.info("Course removed from favourites. CourseId: {}, User: {}", favouriteDto.getCourseId(), email);
		} catch (Exception e) {
			log.error("Failed to remove course from favourites.", e);
			return false;
		}

		user.setFavourites(favourite);
		userRepository.save(user);
		return true;
	}

}
