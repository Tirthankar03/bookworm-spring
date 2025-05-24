package com.aun1x.bookworm.controllers;


import com.aun1x.bookworm.domain.dto.User.LoginUserDto;
import com.aun1x.bookworm.domain.dto.User.Request.LoginUserRequestDto;
import com.aun1x.bookworm.domain.dto.User.Request.RegisterUserRequestDto;
import com.aun1x.bookworm.domain.dto.User.Response.LoginUserResponseDto;
import com.aun1x.bookworm.services.UserService;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log
@RequestMapping("/api/auth")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/register")
//    public ResponseEntity<LoginUserResponseDto> register(@RequestBody RegisterUserRequestDto registerUserRequestDto) {
//
//
//    }
//
//
//    @PostMapping("/login")
//    public ResponseEntity<LoginUserResponseDto> login(@RequestBody LoginUserRequestDto loginUserRequestDto) {
//
//
//    }

    @GetMapping
    public String hello() {
        return "Hello World!";
    }
}
