package com.aun1x.bookworm.domain.dto.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginUserDto {
    private Long id;
    private String username;
    private String email;
    private String profileImage;
}
