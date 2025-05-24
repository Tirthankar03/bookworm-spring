package com.aun1x.bookworm.domain.dto.User.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUserRequestDto {
    private String username;
    private String email;
    private String password;
}
