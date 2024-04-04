package leeyeongjae.yryrserver.jwt.controller;

import leeyeongjae.yryrserver.jwt.domain.JwtService;
import leeyeongjae.yryrserver.jwt.domain.dto.AccessTokenDto;
import leeyeongjae.yryrserver.jwt.domain.dto.TokenRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/token")
@RequiredArgsConstructor
public class JwtController {
    private final JwtService jwtService;
    @PostMapping("/refresh")
    public AccessTokenDto getAccessToken(@RequestBody TokenRequestDto refreshTokenDto) throws Exception {
            return jwtService.getAccessToken(refreshTokenDto);
    }

}
