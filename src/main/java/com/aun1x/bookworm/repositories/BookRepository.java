package com.aun1x.bookworm.repositories;

import com.aun1x.bookworm.domain.entities.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends CrudRepository<BookEntity, Long>,
        PagingAndSortingRepository<BookEntity, Long> { }
