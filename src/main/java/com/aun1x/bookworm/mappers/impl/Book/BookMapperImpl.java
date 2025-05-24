package com.aun1x.bookworm.mappers.impl.Book;

import com.aun1x.bookworm.domain.dto.Book.BookDto;
import com.aun1x.bookworm.domain.entities.BookEntity;
import com.aun1x.bookworm.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements Mapper<BookEntity, BookDto> {
    private final ModelMapper modelMapper;

    public BookMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookEntity mapToEntity(BookDto bookDto) {
        return modelMapper.map(bookDto, BookEntity.class);
    }

    @Override
    public BookDto maptoDto(BookEntity bookEntity) {
        return modelMapper.map(bookEntity, BookDto.class);
    }
}
