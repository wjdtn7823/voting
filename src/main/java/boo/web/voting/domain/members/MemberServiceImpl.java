package boo.web.voting.domain.members;

import boo.web.voting.domain.members.MemberService;
import boo.web.voting.domain.members.Member;
import boo.web.voting.domain.members.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository memberRepository;




    @Override
    public void findByEmail(String email) {

    }


    @Override
    public void duplicateCheck(String email) {

    }


    @Override
    public void deleteMember(String email, String password) {

    }
}
