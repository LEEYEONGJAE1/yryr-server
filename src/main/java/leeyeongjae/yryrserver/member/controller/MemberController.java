package leeyeongjae.yryrserver.member.controller;

import leeyeongjae.yryrserver.domain.jwt.JwtToken;
import leeyeongjae.yryrserver.member.MemberService;
import leeyeongjae.yryrserver.member.domain.dto.MemberCreateResponseDto;
import leeyeongjae.yryrserver.member.domain.dto.SignInDto;
import leeyeongjae.yryrserver.member.domain.dto.SignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/member")
public class MemberController {

    private final MemberService memberService;
    @PostMapping("/signin")
    public JwtToken signIn(@RequestBody SignInDto signInDto) { return memberService.signIn(signInDto.getUsername(), signInDto.getPassword()); }
    @PostMapping("/signup")
    public MemberCreateResponseDto signUp(@RequestBody SignUpDto signUpDto) {
        return memberService.signUp(signUpDto);
    }
}