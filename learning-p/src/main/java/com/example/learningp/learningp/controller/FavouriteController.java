package com.example.learningp.learningp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learningp.learningp.Dto.FavouriteDto;
import com.example.learningp.learningp.service.FavouriteService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/favourite")
public class FavouriteController {
   
	@Autowired
	private FavouriteService favouriteService;
	
	@PostMapping("/make")
	public ResponseEntity<?> makeFavourite(@Valid @RequestBody FavouriteDto favouriteDto){
		return favouriteService.makeFavourite(favouriteDto);
	}
	
	@PostMapping("/remove")
	public ResponseEntity<?> removeFavourite(@Valid @RequestBody FavouriteDto favouriteDto){
		return favouriteService.removeFavourite(favouriteDto);
	}
	
}