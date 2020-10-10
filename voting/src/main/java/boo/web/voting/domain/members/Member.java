package boo.web.voting.domain.members;


import boo.web.voting.web.dto.UserCreateRequestDto;
import boo.web.voting.web.dto.UserUpdateRequestDto;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    private String name;

    private String email;

    private String password;

    @Builder
    public Member(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;

    }

    public void update(UserUpdateRequestDto dto){
        this.password = dto.getPassword();
    }
}
