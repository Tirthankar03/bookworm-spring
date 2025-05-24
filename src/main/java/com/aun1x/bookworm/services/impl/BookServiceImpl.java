package com.aun1x.bookworm.services.impl;

import com.aun1x.bookworm.domain.entities.BookEntity;
import com.aun1x.bookworm.repositories.BookRepository;
import com.aun1x.bookworm.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public BookEntity save(BookEntity book) {
        return bookRepository.save(book);
    }


    @Override
    public Page<BookEntity> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Optional<BookEntity> findOne(Long id) {
        return bookRepository.findById(id);
    }



    @Override
    public void delete(Long id) {

    }
}
