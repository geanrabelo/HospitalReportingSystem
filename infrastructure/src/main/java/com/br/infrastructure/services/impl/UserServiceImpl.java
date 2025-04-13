package com.br.infrastructure.services.impl;

import com.br.core.entity.UserEntity;
import com.br.infrastructure.dto.AuthenticationDTO;
import com.br.infrastructure.dto.RegisterDTO;
import com.br.infrastructure.dto.UserDetailsDTO;
import com.br.infrastructure.mapper.UserMapper;
import com.br.infrastructure.services.UserService;
import com.br.usecases.UserEntityUsecases;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserEntityUsecases userEntityUsecases;

    public UserServiceImpl(UserMapper userMapper, UserEntityUsecases userEntityUsecases){
        this.userMapper = userMapper;
        this.userEntityUsecases = userEntityUsecases;
    }

    @Override
    public String register(RegisterDTO registerDTO) {
        UserEntity userEntity = userMapper.toUserEntity(registerDTO);
        return userEntityUsecases.register(userEntity);
    }

    @Override
    public String login(AuthenticationDTO authenticationDTO) {
        UserEntity userEntity = userMapper.toUserEntity(authenticationDTO);
        return userEntityUsecases.login(userEntity);
    }

    @Override
    public List<UserDetailsDTO> findAll() {
        return userEntityUsecases.findAll().stream().map(userMapper::toUserDetailsDTO).toList();
    }

    @Override
    public UserDetailsDTO findByUserId(Long userId) {
        return userMapper.toUserDetailsDTO(userEntityUsecases.findByUserId(userId));
    }

    @Override
    public void deleteByUserId(Long userId) {
        userEntityUsecases.deleteByUserId(userId);
    }
}
