package com.aun1x.bookworm.controllers;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
@Tag(name = "Book APIs", description = "Create, Get, Delete Books")
@RequestMapping("/api/books")
public class BookController {

}
