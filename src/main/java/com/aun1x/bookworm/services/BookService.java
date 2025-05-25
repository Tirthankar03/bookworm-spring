package com.aun1x.bookworm.services;

import com.aun1x.bookworm.domain.entities.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BookService {

    BookEntity save(BookEntity book, String username);

    //overloading findAll with different return type
    Page<BookEntity> findAll(Pageable pageable);

    Optional<BookEntity> findOne(Long id);


    void delete(Long id);
}
