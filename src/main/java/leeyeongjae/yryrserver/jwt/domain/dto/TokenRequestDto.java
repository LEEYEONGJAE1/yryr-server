package leeyeongjae.yryrserver.jwt.domain.dto;

import lombok.Data;

@Data
public class TokenRequestDto {
    private String refreshToken;
    private String accessToken;
}
