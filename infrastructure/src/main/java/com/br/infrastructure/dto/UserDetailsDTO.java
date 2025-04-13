package com.br.infrastructure.dto;

import com.br.core.entity.UserEntity;
import com.br.core.enums.Roles;

public record UserDetailsDTO(Long userId, String login, Roles roles) {
    public UserDetailsDTO(UserEntity userEntity){
        this(userEntity.getUserId(), userEntity.getLogin(), userEntity.getRoles());
    }
}
