package web.boo.authcenter.util;

import jdk.nashorn.internal.parser.Token;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Service
public class CookieUtil {
    public Cookie createCookie(String cookieName, String value){
        System.out.println(cookieName + " " + value);
        Cookie token = new Cookie(cookieName,value);
       // token.setHttpOnly(true); 보안 이슈
       // token.setMaxAge(0);
        token.setMaxAge((int) TokenProvider.TOKEN_VALIDATION_SECOND);
        return token;
    }

    public Cookie getCookie(HttpServletRequest req, String cookieName){
        final Cookie[] cookies = req.getCookies();
        if(cookies==null) return null;
        for(Cookie cookie : cookies){
            if(cookie.getName().equals(cookieName))
                return cookie;
        }
        return null;
    }
}
