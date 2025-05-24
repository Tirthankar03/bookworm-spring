package com.aun1x.bookworm.mappers.impl.User;

import com.aun1x.bookworm.domain.dto.User.LoginUserDto;
import com.aun1x.bookworm.domain.entities.UserEntity;
import com.aun1x.bookworm.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LoginUserMapperImpl implements Mapper<UserEntity, LoginUserDto> {
    private final ModelMapper modelMapper;

    public LoginUserMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserEntity mapToEntity(LoginUserDto loginUserDto) {
        return modelMapper.map(loginUserDto, UserEntity.class);
    }

    @Override
    public LoginUserDto maptoDto(UserEntity userEntity) {
        return modelMapper.map(userEntity, LoginUserDto.class);
    }
}
