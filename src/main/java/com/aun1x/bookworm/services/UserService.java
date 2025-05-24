package com.aun1x.bookworm.services;

import com.aun1x.bookworm.domain.dto.User.Response.LoginUserResponseDto;
import com.aun1x.bookworm.domain.entities.UserEntity;

import java.util.Optional;

public interface UserService {
    UserEntity save(UserEntity user);

    Optional<UserEntity> findOne(long id);

    boolean isExists(Long id);

    void delete(Long id);

    LoginUserResponseDto register(UserEntity authorEntity);

    LoginUserResponseDto login(UserEntity authorEntity);

    Optional<UserEntity> findByUsername(String username);
}
