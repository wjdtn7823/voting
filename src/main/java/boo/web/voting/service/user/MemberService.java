package boo.web.voting.service.user;

import boo.web.voting.model.user.JoinRequest;
import boo.web.voting.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    void findByEmail(String email);

    void join(JoinRequest joinRequest);

    void duplicateCheck(String email);

    void deleteMember(String email, String password);
}
