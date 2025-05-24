package com.aun1x.bookworm.domain.dto.User;

import com.aun1x.bookworm.domain.entities.BookEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String profileImage;

    @JsonIgnoreProperties("user")
    private List<BookEntity> books;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
