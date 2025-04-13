package com.br.infrastructure.mapper;

import com.br.core.entity.UserEntity;
import com.br.infrastructure.domain.User;
import com.br.infrastructure.dto.AuthenticationDTO;
import com.br.infrastructure.dto.RegisterDTO;
import com.br.infrastructure.dto.UserDetailsDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(UserEntity userEntity){
        return User.builder()
                .userId(userEntity.getUserId())
                .login(userEntity.getLogin())
                .password(userEntity.getPassword())
                .roles(userEntity.getRoles())
                .build();
    }


    public UserEntity toUserEntity(User user){
        return new UserEntity.UserEntityBuilder()
                .builder()
                .userId(user.getUserId())
                .login(user.getLogin())
                .password(user.getPassword())
                .roles(user.getRoles())
                .build();
    }

    public UserEntity toUserEntity(AuthenticationDTO authenticationDTO){
        return new UserEntity.UserEntityBuilder()
                .builder()
                .login(authenticationDTO.login())
                .password(authenticationDTO.password())
                .build();
    }

    public UserEntity toUserEntity(RegisterDTO registerDTO){
        return new UserEntity.UserEntityBuilder()
                .builder()
                .login(registerDTO.login())
                .password(registerDTO.password())
                .roles(registerDTO.roles())
                .build();
    }

    public UserDetailsDTO toUserDetailsDTO(UserEntity userEntity){
        return new UserDetailsDTO(userEntity);
    }

}
