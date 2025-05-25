package com.aun1x.bookworm.services.impl;

import com.aun1x.bookworm.domain.entities.BookEntity;
import com.aun1x.bookworm.domain.entities.UserEntity;
import com.aun1x.bookworm.repositories.BookRepository;
import com.aun1x.bookworm.repositories.UserRepository;
import com.aun1x.bookworm.services.BookService;
import com.aun1x.bookworm.services.CloudinaryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CloudinaryService cloudinaryService;
    private final UserRepository userRepository;
    public BookServiceImpl(BookRepository bookRepository, CloudinaryService cloudinaryService, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.cloudinaryService = cloudinaryService;
        this.userRepository = userRepository;
    }


    @Override
    public BookEntity save(BookEntity book, String username) {

        System.out.println("username = " + username);
        System.out.println("book = " + book);

        Optional<UserEntity> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found with username: " + username);
        }

        UserEntity user = userOptional.get();
        String imageUrl = cloudinaryService.uploadImage(book.getImage(), "books");
        System.out.println("imageUrl = " + imageUrl);

        book.setImage(imageUrl);

        //set the user for the book
        book.setUser(user);


        System.out.println("book after setting user and imageUrl = " + book);

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
