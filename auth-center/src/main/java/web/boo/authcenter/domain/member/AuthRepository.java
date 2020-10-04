package web.boo.authcenter.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Member,Long> {

    Optional<Member> findByEmailAndPassword(String email,String password);
}
