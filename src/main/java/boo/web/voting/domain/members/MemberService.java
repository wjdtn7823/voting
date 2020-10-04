package boo.web.voting.domain.members;

import boo.web.voting.web.dto.UserCreateRequestDto;
import boo.web.voting.web.dto.UserDeleteRequestDto;
import boo.web.voting.web.dto.UserLoginRequestDto;
import boo.web.voting.web.dto.UserUpdateRequestDto;
import org.springframework.stereotype.Service;


public interface MemberService {

    Member findByEmail(String email);


    Member duplicateCheck(String email);

    void deleteMember(UserDeleteRequestDto requestDto);

    void updateMember(String email, UserUpdateRequestDto dto);

    Long createUser(UserCreateRequestDto requestDto);

}
