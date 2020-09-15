package boo.web.voting.domain.members;

import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    void findByEmail(String email);


    void duplicateCheck(String email);

    void deleteMember(String email, String password);
}
