package web.boo.authcenter.domain.member;


import web.boo.authcenter.dto.request.UserLoginRequestDto;

public interface MemberService {


    Member login(UserLoginRequestDto requestDto);
}
