package com.aun1x.bookworm.domain.dto.Book.Request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBookRequestDto {
    @NotNull
    private String title;
    @NotNull
    private String caption;
    @NotNull
    private String image;
    @NotNull
    private Integer rating;
}
