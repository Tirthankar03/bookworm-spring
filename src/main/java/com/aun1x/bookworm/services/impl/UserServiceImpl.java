package com.aun1x.bookworm.services.impl;

import com.aun1x.bookworm.domain.dto.User.LoginUserDto;
import com.aun1x.bookworm.domain.dto.User.Response.LoginUserResponseDto;
import com.aun1x.bookworm.domain.entities.UserEntity;
import com.aun1x.bookworm.mappers.Mapper;
import com.aun1x.bookworm.repositories.UserRepository;
import com.aun1x.bookworm.security.JwtService;
import com.aun1x.bookworm.services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final Mapper<UserEntity, LoginUserDto> loginUserMapper;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserServiceImpl(UserRepository userRepository, AuthenticationManager authManager, JwtService jwtService, Mapper<UserEntity, LoginUserDto> loginUserMapper) {
        this.userRepository = userRepository;
        this.authManager = authManager;
        this.jwtService = jwtService;

        this.loginUserMapper = loginUserMapper;
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
    public LoginUserResponseDto register(UserEntity userEntity) {
        // Store the plain-text password for authentication
        String plainPassword = userEntity.getPassword();
        System.out.println("password>>>>>>" + plainPassword);
        System.out.println("register>>>>>>" + userEntity);

        // Generate profile image using Dicebear
        String profileImage = "https://api.dicebear.com/7.x/avataaars/svg?seed=" + userEntity.getUsername();
        userEntity.setProfileImage(profileImage);

        // Encode the password and save the entity
        userEntity.setPassword(encoder.encode(plainPassword));


        UserEntity savedUser = userRepository.save(userEntity);



        // Create a new UserEntity for login with plain-text password
        UserEntity loginUser = UserEntity.builder()
                .username(savedUser.getUsername())
                .password(plainPassword)
                .build();
        System.out.println("loginUser>>>>>>" + loginUser);

        // Authenticate using the plain-text password
        return login(loginUser);
    }

    @Override
    public LoginUserResponseDto login(UserEntity userEntity) {
        //        System.out.println("login>>>>>>" + userEntity);

        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(userEntity.getUsername(), userEntity.getPassword())
        );

//        System.out.println("auth>>>>>>" + auth);


        if(auth.isAuthenticated()) {


            String token = jwtService.generateToken(userEntity.getUsername());
            UserEntity user = userRepository.findByUsername(userEntity.getUsername())
                    .orElseThrow(() -> new RuntimeException("User not found after authentication"));

            LoginUserDto userDto = loginUserMapper.maptoDto(user);

            return LoginUserResponseDto.builder()
                    .token(token)
                    .user(userDto)
                    .build();
        }

        throw new RuntimeException("Authentication failed");
    }

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
