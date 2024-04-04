package leeyeongjae.yryrserver.jwt.domain;

import leeyeongjae.yryrserver.common.exception.NotFoundException;
import leeyeongjae.yryrserver.jwt.JwtTokenProvider;
import leeyeongjae.yryrserver.jwt.domain.dto.AccessTokenDto;
import leeyeongjae.yryrserver.jwt.domain.dto.TokenRequestDto;
import leeyeongjae.yryrserver.member.domain.Member;
import leeyeongjae.yryrserver.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.security.Principal;


@Service
@RequiredArgsConstructor
public class JwtService {
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtRepository jwtRepository;
    private final MemberRepository memberRepository;
    public AccessTokenDto getAccessToken(TokenRequestDto tokenRequestDto) throws Exception {
        if(jwtTokenProvider.validateToken(tokenRequestDto.getRefreshToken())){
            Authentication authentication = jwtTokenProvider.getAuthentication(tokenRequestDto.getAccessToken());
            Member member= memberRepository.findByUsername(authentication.getName()).orElseThrow();
            RefreshToken refreshToken = jwtRepository.findByUsername(member.getUsername()).orElseThrow();
            if (refreshToken.getToken().equals(tokenRequestDto.getRefreshToken())) {
                String accessToken= jwtTokenProvider.generateAccessToken(authentication);
                return AccessTokenDto.builder()
                        .accessToken(accessToken).build();
            }
            else {
                throw new Exception("err");
            }
        }
        else{
            throw new Exception("err");
        }
    }
}
