package com.aun1x.bookworm.controllers;

import com.aun1x.bookworm.domain.dto.User.Request.LoginUserRequestDto;
import com.aun1x.bookworm.domain.dto.User.Request.RegisterUserRequestDto;
import com.aun1x.bookworm.domain.dto.User.Response.LoginUserResponseDto;
import com.aun1x.bookworm.domain.entities.UserEntity;
import com.aun1x.bookworm.mappers.Mapper;
import com.aun1x.bookworm.services.UserService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final Mapper<UserEntity, RegisterUserRequestDto> registerUserRequestDtoMapper;
    private final Mapper<UserEntity, LoginUserRequestDto> loginUserRequestDtoMapper;


    public AuthController(UserService userService, Mapper<UserEntity, RegisterUserRequestDto> registerUserRequestDtoMapper, Mapper<UserEntity, LoginUserRequestDto> loginUserRequestDtoMapper) {
        this.userService = userService;
        this.registerUserRequestDtoMapper = registerUserRequestDtoMapper;
        this.loginUserRequestDtoMapper = loginUserRequestDtoMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<LoginUserResponseDto> register(@RequestBody RegisterUserRequestDto registerUserRequestDto) {
        System.out.println("registerUserRequestDto>>>" + registerUserRequestDto);

        //map the dto to entity
        UserEntity userEntity = registerUserRequestDtoMapper.mapToEntity(registerUserRequestDto);

        LoginUserResponseDto loginUserResponseDto = userService.register(userEntity);

        return new ResponseEntity<>(loginUserResponseDto, HttpStatus.OK);

    }


    @PostMapping("/login")
    public ResponseEntity<LoginUserResponseDto> login(@RequestBody LoginUserRequestDto loginUserRequestDto) {
        //map the dto to entity
        UserEntity userEntity = loginUserRequestDtoMapper.mapToEntity(loginUserRequestDto);
        LoginUserResponseDto loginUserResponseDto = userService.login(userEntity);
        return new ResponseEntity<>(loginUserResponseDto, HttpStatus.OK);

    }


    @GetMapping
    public String hello() {
        return "Hello World!";
    }
}
