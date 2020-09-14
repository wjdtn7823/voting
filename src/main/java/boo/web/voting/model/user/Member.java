package boo.web.voting.model.user;


import boo.web.voting.model.group.Team;
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
    private long id ;

    private String name;

    private String email;

    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;
}
