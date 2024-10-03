package org.example.nishiki_koi_shop.model.dto;

import lombok.Builder;
import lombok.Data;
import org.example.nishiki_koi_shop.model.entity.User;

@Data
@Builder
public class AuthDto {
    private Long id;
    private String token;
    private String refreshToken;
    private String result;

    public AuthDto(Long id, String token, String refreshToken, String result) {
        this.id = id;
        this.token = token;
        this.refreshToken = refreshToken;
        this.result = result;
    }

    public static AuthDto from(User user, String token, String refreshToken, String result) {
        return AuthDto.builder()
                .id(user.getId())
                .token(token)
                .refreshToken(refreshToken)
                .result(result)
                .build();
    }
}
