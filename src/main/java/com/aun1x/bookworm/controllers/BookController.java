package com.aun1x.bookworm.controllers;


import com.aun1x.bookworm.domain.dto.Book.BookDto;
import com.aun1x.bookworm.domain.dto.Book.Request.CreateBookRequestDto;
import com.aun1x.bookworm.domain.entities.BookEntity;
import com.aun1x.bookworm.mappers.Mapper;
import com.aun1x.bookworm.services.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@Log
@Tag(name = "Book APIs", description = "Create, Get, Delete Books")
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    private final Mapper<BookEntity, CreateBookRequestDto> createBookRequestMapper;
    private final Mapper<BookEntity, BookDto> bookMapper;

    public BookController(BookService bookService, Mapper<BookEntity, CreateBookRequestDto> createBookRequestMapper, Mapper<BookEntity, BookDto> bookMapper) {
        this.bookService = bookService;
        this.createBookRequestMapper = createBookRequestMapper;
        this.bookMapper = bookMapper;
    }

    @PostMapping
    public ResponseEntity<BookEntity> createBook(@RequestBody CreateBookRequestDto request) {
        try {
            System.out.println("request" + request);
            BookEntity bookEntity = createBookRequestMapper.mapToEntity(request);
            System.out.println("bookEntity after mapping from DTO" + bookEntity);

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            BookEntity savedBook = bookService.save(bookEntity, username);

            return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error creating book: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Page<BookDto>> listBooks(Pageable pageable) {
        Page<BookEntity> books = bookService.findAll(pageable);

        //convert list of book entities to book dtos

        return new ResponseEntity<>(books.map(bookMapper::maptoDto), HttpStatus.OK) ;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteBook(@PathVariable("id") Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        bookService.delete(id, username);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
