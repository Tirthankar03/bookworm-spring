package com.aun1x.bookworm.controllers;


import com.aun1x.bookworm.domain.dto.User.LoginUserDto;
import com.aun1x.bookworm.domain.dto.User.Request.LoginUserRequestDto;
import com.aun1x.bookworm.domain.dto.User.Request.RegisterUserRequestDto;
import com.aun1x.bookworm.domain.dto.User.Response.LoginUserResponseDto;
import com.aun1x.bookworm.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log
@Tag(name = "User APIs")
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



}
