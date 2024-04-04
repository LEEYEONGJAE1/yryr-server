package leeyeongjae.yryrserver.jwt.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccessTokenDto {
    private String accessToken;
}
