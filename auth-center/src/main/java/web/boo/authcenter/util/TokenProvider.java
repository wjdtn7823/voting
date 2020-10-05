package web.boo.authcenter.util;

import com.auth0.jwt.interfaces.Claim;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import web.boo.authcenter.domain.member.Member;

import java.util.Date;


@Service
public class TokenProvider {

    public final static String ACCESS_TOKEN_NAME="accesstoken";

    public final static String REFRESH_TOKEN_NAME="refreshtoken";

    @Value("${spring.jwt.access-expired-time}")
    public static long TOKEN_VALIDATION_SECOND;

    @Value("${spring.jwt.access-expired-time}")
    public static long REFRESH_TOKEN_VALIDATION_SECOND;

    @Value("${spring.jwt.secret}")
    private String SECRET_KEY;

    public String generateToken(Member member){
        return doGenerateToken(member.getName(), ACCESS_TOKEN_NAME,TOKEN_VALIDATION_SECOND);
    }

    public String generateRefreshToken(Member member){
        return doGenerateToken(member.getName(), REFRESH_TOKEN_NAME, REFRESH_TOKEN_VALIDATION_SECOND);
    }
    private String doGenerateToken(String name, String access_token_name, long expired_time) {
        Claims claims = Jwts.claims().setSubject(name);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*expired_time))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY+ access_token_name)
                .compact();
    }


}
