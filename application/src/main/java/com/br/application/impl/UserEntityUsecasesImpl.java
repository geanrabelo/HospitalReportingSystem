package com.br.application.impl;

import com.br.application.gateway.UserEntityGateway;
import com.br.core.entity.UserEntity;
import com.br.usecases.UserEntityUsecases;

import java.util.List;

public class UserEntityUsecasesImpl implements UserEntityUsecases {

    private final UserEntityGateway userEntityGateway;

    public UserEntityUsecasesImpl(UserEntityGateway userEntityGateway){
        this.userEntityGateway = userEntityGateway;
    }

    @Override
    public String register(UserEntity userEntity) {
        return userEntityGateway.register(userEntity);
    }

    @Override
    public String login(UserEntity userEntity) {
        return userEntityGateway.login(userEntity);
    }

    @Override
    public List<UserEntity> findAll() {
        return userEntityGateway.findAll();
    }

    @Override
    public UserEntity findByUserId(Long userId) {
        return userEntityGateway.findByUserId(userId);
    }

    @Override
    public void deleteByUserId(Long userId) {
        userEntityGateway.deleteByUserId(userId);
    }
}
