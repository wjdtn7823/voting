package boo.web.voting.domain.members;

import boo.web.voting.domain.members.MemberService;
import boo.web.voting.domain.members.Member;
import boo.web.voting.domain.members.MemberRepository;
import boo.web.voting.web.dto.UserCreateRequestDto;
import boo.web.voting.web.dto.UserDeleteRequestDto;
import boo.web.voting.web.dto.UserLoginRequestDto;
import boo.web.voting.web.dto.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException());
    }


    @Override
    public Member duplicateCheck(String email) {
        return memberRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("사용할수 없는 아이디입니다."));
    }


    @Override
    public void deleteMember(UserDeleteRequestDto requestDto) {
        Member member = memberRepository.findByEmailAndPassword(requestDto.getEmail(),requestDto.getPassword()).orElseThrow(()->new IllegalArgumentException("아이디 비밀번호가 일치 하지 않습니다."));
        memberRepository.delete(member);
    }

    @Override
    public void updateMember(String email, UserUpdateRequestDto dto) {

        Member member = memberRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException());
        member.update(dto);
        memberRepository.save(member);
    }

    @Override
    public Long createUser(UserCreateRequestDto requestDto) {
        System.out.println("createUser");
        Member member = requestDto.toMemberEntity();
        System.out.println(member);
         return memberRepository.save(member).getId();
    }

    @Override
    public void login(UserLoginRequestDto requestDto) {

        memberRepository.findByEmailAndPassword(requestDto.getEmail(), requestDto.getPassword()).orElseThrow(()->new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다."));
    }
}
