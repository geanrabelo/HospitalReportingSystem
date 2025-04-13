package com.br.infrastructure.gatewayImpl;

import com.br.application.gateway.UserEntityGateway;
import com.br.core.entity.UserEntity;
import com.br.core.enums.EnumCode;
import com.br.core.exceptions.LoginAlreadyExists;
import com.br.core.exceptions.UserIdNotFound;
import com.br.infrastructure.domain.User;
import com.br.infrastructure.mapper.UserMapper;
import com.br.infrastructure.repositories.UserRepository;
import com.br.infrastructure.services.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityGatewayImpl implements UserEntityGateway {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserMapper userMapper;

    public UserEntityGatewayImpl(UserRepository userRepository, AuthenticationManager authenticationManager, TokenService tokenService, UserMapper userMapper){
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.userMapper = userMapper;
    }

    @Override
    public String login(UserEntity userEntity) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(userEntity.getLogin(), userEntity.getPassword());
        var auth = authenticationManager.authenticate(usernamePassword);

        return tokenService.generateToken((User) auth.getPrincipal());
    }

    @Override
    public String register(UserEntity userEntity) {
        if(userRepository.findByLogin(userEntity.getLogin()) != null){
            throw new LoginAlreadyExists(EnumCode.LOG0000.getMessage());
        }

        var passwordCryp = new BCryptPasswordEncoder().encode(userEntity.getPassword());

        User user = User.builder()
                .login(userEntity.getLogin())
                .password(passwordCryp)
                .roles(userEntity.getRoles())
                .build();

        userRepository.save(user);

        return "Registered successfully";
    }


    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll().stream().map(userMapper::toUserEntity).toList();
    }

    @Override
    public UserEntity findByUserId(Long userId) {
        if(userRepository.existsById(userId)){
            return userMapper.toUserEntity(userRepository.getReferenceById(userId));
        }
        throw new UserIdNotFound(EnumCode.USR0000.getMessage());
    }

    @Override
    public void deleteByUserId(Long userId) {
        if(userRepository.existsById(userId)){
            userRepository.deleteById(userId);
        }else{
            throw new UserIdNotFound(EnumCode.USR0000.getMessage());
        }
    }

}
