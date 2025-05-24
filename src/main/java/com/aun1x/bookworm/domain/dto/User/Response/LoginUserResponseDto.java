package com.aun1x.bookworm.domain.dto.User.Response;

import com.aun1x.bookworm.domain.dto.User.LoginUserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginUserResponseDto {
    private String token;
    private LoginUserDto user;
}
