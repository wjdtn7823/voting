package boo.web.voting.web.dto;

import boo.web.voting.domain.members.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserCreateRequestDto {

    private String email;
    private String name;
    private String password;

    public Member toMemberEntity(){
        return Member.builder().email(email).name(name).password(password).build();
    }

}
