package com.br.usecases;

import com.br.core.entity.UserEntity;

import java.util.List;

public interface UserEntityUsecases {

    String register(UserEntity userEntity);

    String login (UserEntity userEntity);

    List<UserEntity> findAll();

    UserEntity findByUserId(Long userId);

    void deleteByUserId(Long userId);
}
