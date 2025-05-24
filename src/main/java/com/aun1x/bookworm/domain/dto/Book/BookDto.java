package com.aun1x.bookworm.domain.dto.Book;

import com.aun1x.bookworm.domain.entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    private Long id;
    private String title;
    private String caption;
    private String image;
    private Integer rating;

    @JsonIgnoreProperties("books")
    private UserEntity user;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
