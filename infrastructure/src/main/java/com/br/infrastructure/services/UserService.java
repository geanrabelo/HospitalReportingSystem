package com.br.infrastructure.services;

import com.br.core.entity.UserEntity;
import com.br.infrastructure.dto.AuthenticationDTO;
import com.br.infrastructure.dto.RegisterDTO;
import com.br.infrastructure.dto.UserDetailsDTO;

import java.util.List;

public interface UserService {

    String register(RegisterDTO registerDTO);

    String login (AuthenticationDTO authenticationDTO);

    List<UserDetailsDTO> findAll();

    UserDetailsDTO findByUserId(Long userId);

    void deleteByUserId(Long userId);

}
