package com.aun1x.bookworm.services.impl;

import com.aun1x.bookworm.domain.dto.User.Response.LoginUserResponseDto;
import com.aun1x.bookworm.domain.entities.UserEntity;
import com.aun1x.bookworm.repositories.UserRepository;
import com.aun1x.bookworm.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public Optional<UserEntity> findOne(long id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean isExists(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }


    //implement after spring security
    @Override
    public LoginUserResponseDto register(UserEntity authorEntity) {
        return null;
    }

    @Override
    public LoginUserResponseDto login(UserEntity authorEntity) {
        return null;
    }
}
