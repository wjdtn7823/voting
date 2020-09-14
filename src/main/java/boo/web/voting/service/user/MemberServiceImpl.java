package boo.web.voting.service.user;

import boo.web.voting.model.user.JoinRequest;
import boo.web.voting.model.user.Member;
import boo.web.voting.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberRepository memberRepository;




    @Override
    public void findByEmail(String email) {

    }

    @Override
    public void join(JoinRequest joinRequest) {


        memberRepository.save(new Member());
    }

    @Override
    public void duplicateCheck(String email) {

    }


    @Override
    public void deleteMember(String email, String password) {

    }
}
