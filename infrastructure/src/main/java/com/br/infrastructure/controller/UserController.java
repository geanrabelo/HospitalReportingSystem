package com.br.infrastructure.controller;

import com.br.infrastructure.dto.AuthenticationDTO;
import com.br.infrastructure.dto.MessageDTO;
import com.br.infrastructure.dto.RegisterDTO;
import com.br.infrastructure.dto.TokenDTO;
import com.br.infrastructure.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hrs/auth")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody AuthenticationDTO authenticationDTO){
        return ResponseEntity.ok(new TokenDTO(userService.login(authenticationDTO)));
    }

    @PostMapping("/register")
    public ResponseEntity<MessageDTO> register(@RequestBody RegisterDTO registerDTO){
        return ResponseEntity.ok(new MessageDTO(userService.register(registerDTO)));
    }


}
