package com.aun1x.bookworm.mappers.impl.User;

import com.aun1x.bookworm.domain.dto.User.LoginUserDto;
import com.aun1x.bookworm.domain.dto.User.Request.LoginUserRequestDto;
import com.aun1x.bookworm.domain.entities.UserEntity;
import com.aun1x.bookworm.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LoginUserRequestMapperImpl implements Mapper<UserEntity, LoginUserRequestDto> {
    private final ModelMapper modelMapper;

    public LoginUserRequestMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserEntity mapToEntity(LoginUserRequestDto loginUserRequestDto) {
        return modelMapper.map(loginUserRequestDto, UserEntity.class);
    }

    @Override
    //not supposed to be used
    public LoginUserRequestDto maptoDto(UserEntity userEntity) {
        throw new UnsupportedOperationException("this mapper is only for requests");
    }
}
