package com.example.learningp.learningp.mapper;

import com.example.learningp.learningp.Dto.RegisterUserDto;
import com.example.learningp.learningp.entity.Role;
import com.example.learningp.learningp.entity.User;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-15T15:40:27+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User registerUserDtoToUser(RegisterUserDto registerUser) {
        if ( registerUser == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( registerUser.getEmail() );
        user.setName( registerUser.getName() );
        user.setPassword( registerUser.getPassword() );
        Set<Role> set = registerUser.getRoles();
        if ( set != null ) {
            user.setRoles( new LinkedHashSet<Role>( set ) );
        }

        return user;
    }

    @Override
    public RegisterUserDto userToRegisterUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        RegisterUserDto registerUserDto = new RegisterUserDto();

        registerUserDto.setEmail( user.getEmail() );
        registerUserDto.setName( user.getName() );
        registerUserDto.setPassword( user.getPassword() );
        Set<Role> set = user.getRoles();
        if ( set != null ) {
            registerUserDto.setRoles( new LinkedHashSet<Role>( set ) );
        }

        return registerUserDto;
    }
}
