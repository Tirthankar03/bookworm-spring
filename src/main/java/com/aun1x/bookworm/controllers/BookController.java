package com.aun1x.bookworm.controllers;


import com.aun1x.bookworm.domain.dto.Book.Request.CreateBookRequestDto;
import com.aun1x.bookworm.domain.entities.BookEntity;
import com.aun1x.bookworm.mappers.Mapper;
import com.aun1x.bookworm.services.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
@Tag(name = "Book APIs", description = "Create, Get, Delete Books")
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    private final Mapper<BookEntity, CreateBookRequestDto> createBookRequestMapper;

    public BookController(BookService bookService, Mapper<BookEntity, CreateBookRequestDto> createBookRequestMapper) {
        this.bookService = bookService;
        this.createBookRequestMapper = createBookRequestMapper;
    }

    @PostMapping
    public ResponseEntity<BookEntity> createBook(@RequestBody CreateBookRequestDto request) {

        System.out.println("request" + request);
        //convert to entity
        BookEntity bookEntity = createBookRequestMapper.mapToEntity(request);

        System.out.println("bookEntity after mapping from DTO" + bookEntity);


        //get user from security context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        BookEntity savedBook = bookService.save(bookEntity, username);

        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

}
