package web.boo.authcenter.domain.member;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.boo.authcenter.dto.request.UserLoginRequestDto;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final AuthRepository authRepository;

    @Override
    public Member login(UserLoginRequestDto requestDto) {
       return authRepository.findByEmailAndPassword(requestDto.getEmail(), requestDto.getPassword())
                .orElseThrow(()->new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다."));
    }
}
