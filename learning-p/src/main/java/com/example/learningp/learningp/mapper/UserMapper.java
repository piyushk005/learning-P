package com.example.learningp.learningp.mapper;

import org.mapstruct.Mapper;

import com.example.learningp.learningp.Dto.RegisterUserDto;
import com.example.learningp.learningp.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

User registerUserDtoToUser(RegisterUserDto registerUser);
	
RegisterUserDto userToRegisterUserDto(User user);
}
