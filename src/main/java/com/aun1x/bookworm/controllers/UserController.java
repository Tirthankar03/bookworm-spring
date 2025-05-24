package com.aun1x.bookworm.controllers;


import com.aun1x.bookworm.domain.dto.Book.BookDto;
import com.aun1x.bookworm.domain.dto.User.LoginUserDto;
import com.aun1x.bookworm.domain.dto.User.Request.LoginUserRequestDto;
import com.aun1x.bookworm.domain.dto.User.Request.RegisterUserRequestDto;
import com.aun1x.bookworm.domain.dto.User.Response.LoginUserResponseDto;
import com.aun1x.bookworm.domain.entities.BookEntity;
import com.aun1x.bookworm.domain.entities.UserEntity;
import com.aun1x.bookworm.exceptions.ResourceNotFoundException;
import com.aun1x.bookworm.mappers.Mapper;
import com.aun1x.bookworm.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Log
@Tag(name = "User APIs")
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final Mapper<BookEntity, BookDto> bookMapper;

    public UserController(UserService userService, Mapper<BookEntity, BookDto> bookMapper) {
        this.userService = userService;
        this.bookMapper = bookMapper;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //yet to test
    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getBooksUserByUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        System.out.println("authentication.getDetails()" + authentication.getDetails());
        System.out.println("authentication.getPrincipal()" + authentication.getPrincipal());
        System.out.println("authentication.getCredentials()" + authentication.getCredentials());


        String username = authentication.getName();

        UserEntity author = userService.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Author with name " + username + " not found"));

        List<BookDto> bookDtos = author.getBooks().stream()
                .map( book -> bookMapper.maptoDto(book) )
                .collect(Collectors.toList());

        return new ResponseEntity<>(bookDtos, HttpStatus.OK);
    }



}
