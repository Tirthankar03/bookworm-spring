package com.aun1x.bookworm.mappers.impl.User;

import com.aun1x.bookworm.domain.dto.User.UserDto;
import com.aun1x.bookworm.domain.entities.UserEntity;
import com.aun1x.bookworm.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements Mapper<UserEntity, UserDto> {
    private final ModelMapper modelMapper;

    public UserMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserEntity mapToEntity(UserDto userDto) {
        return modelMapper.map(userDto, UserEntity.class);
    }

    @Override
    public UserDto maptoDto(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDto.class);
    }
}
