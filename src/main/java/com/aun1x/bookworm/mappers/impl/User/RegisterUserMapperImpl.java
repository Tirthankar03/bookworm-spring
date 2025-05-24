package com.aun1x.bookworm.mappers.impl.User;

import com.aun1x.bookworm.domain.dto.User.Request.RegisterUserRequestDto;
import com.aun1x.bookworm.domain.entities.UserEntity;
import com.aun1x.bookworm.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserMapperImpl implements Mapper<UserEntity, RegisterUserRequestDto> {
    private final ModelMapper modelMapper;

    public RegisterUserMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserEntity mapToEntity(RegisterUserRequestDto registerUserRequestDto) {
        return modelMapper.map(registerUserRequestDto, UserEntity.class);
    }

    @Override
    public RegisterUserRequestDto maptoDto(UserEntity userEntity) {
        return modelMapper.map(userEntity, RegisterUserRequestDto.class);
    }
}
