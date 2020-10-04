package web.boo.authcenter.domain.member;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.boo.authcenter.dto.request.UserLoginRequestDto;
import web.boo.authcenter.util.CookieUtil;
import web.boo.authcenter.util.TokenProvider;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {


    private final MemberService memberService;
    private final TokenProvider tokenProvider;

    private final CookieUtil cookieUtil;

    @PostMapping("/auth/login")
    ResponseEntity login(@RequestBody UserLoginRequestDto requestDto, HttpServletResponse response) {

        Member member = memberService.login(requestDto);
        Map<String, String> map = new HashMap<>();
        String accessToken = tokenProvider.generateToken(member);
        String refreshToken = tokenProvider.generateRefreshToken(member);
        response.addCookie(cookieUtil.createCookie(TokenProvider.ACCESS_TOKEN_NAME, accessToken));
        response.addCookie(cookieUtil.createCookie(TokenProvider.REFRESH_TOKEN_NAME, refreshToken));
       // response.addCookie(new Cookie("foo","bar"));
        return new ResponseEntity(accessToken,HttpStatus.OK);
    }


}