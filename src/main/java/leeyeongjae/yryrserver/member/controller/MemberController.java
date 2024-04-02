package leeyeongjae.yryrserver.member.controller;

import leeyeongjae.yryrserver.auth.domain.dto.JwtToken;
import leeyeongjae.yryrserver.member.MemberService;
import leeyeongjae.yryrserver.member.SecurityUtil;
import leeyeongjae.yryrserver.member.domain.dto.MemberCreateResponseDto;
import leeyeongjae.yryrserver.member.domain.dto.SignInDto;
import leeyeongjae.yryrserver.member.domain.dto.SignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/sign-in")
    public JwtToken signIn(@RequestBody SignInDto signInDto) {
        String username = signInDto.getUsername();
        String password = signInDto.getPassword();
        JwtToken jwtToken = memberService.signIn(username, password);
        return jwtToken;
    }
    @PostMapping("/sign-up")
    public MemberCreateResponseDto signUp(@RequestBody SignUpDto signUpDto) {
        return memberService.signUp(signUpDto);
    }

    @PostMapping("/test")
    public String test() {
        return SecurityUtil.getCurrentUsername();
    }
}