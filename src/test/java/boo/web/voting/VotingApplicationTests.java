package boo.web.voting;

import boo.web.voting.model.user.Member;
import boo.web.voting.repo.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
class VotingApplicationTests {
    @Autowired
    EntityManager em;

    @Test
    void contextLoads() {
        Member m = em.find(Member.class, 1l);
        System.out.println("m의 클래스  " + m.getClass());
        System.out.println("-----  조회결과 "  +  m.getName());
        Member pm = em.getReference(Member.class, 1l);


        System.out.println("pm  조회결과"   + pm.getName());
        System.out.println("pm의 클래스  " + pm.getClass());
        //String name =  pm.getName();
        System.out.println("pm의 클래스  " + pm.getClass());

    }


}
