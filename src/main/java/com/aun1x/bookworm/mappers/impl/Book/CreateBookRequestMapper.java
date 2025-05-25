package com.aun1x.bookworm.mappers.impl.Book;

import com.aun1x.bookworm.domain.dto.Book.Request.CreateBookRequestDto;
import com.aun1x.bookworm.domain.entities.BookEntity;
import com.aun1x.bookworm.mappers.Mapper;
import org.springframework.stereotype.Component;

@Component
public class CreateBookRequestMapper implements Mapper<BookEntity, CreateBookRequestDto> {

    @Override
    public BookEntity mapToEntity(CreateBookRequestDto dto) {
        return BookEntity.builder()
                .title(dto.getTitle())
                .caption(dto.getCaption())
                .image(dto.getImage())
                .rating(dto.getRating())
                .build();
    }

    @Override
    public CreateBookRequestDto maptoDto(BookEntity bookEntity) {
        throw new UnsupportedOperationException("This mapper is only for creating BookEntity from CreateBookRequestDto");

    }
}