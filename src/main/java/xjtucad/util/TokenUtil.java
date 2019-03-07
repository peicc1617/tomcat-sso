package xjtucad.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenUtil {
    public static void clearToken(HttpServletRequest request, HttpServletResponse response){
        Cookie tokenCookie = new Cookie(KeyName.TOKEN,"");
        tokenCookie.setMaxAge(0);
        tokenCookie.setPath("/");

        Cookie userInfoCookie = new Cookie(KeyName.COOKIE_USER_INFO,"");
        userInfoCookie.setMaxAge(0);
        userInfoCookie.setPath("/");

        response.addCookie(tokenCookie);
        response.addCookie(userInfoCookie);

        request.getSession().removeAttribute(KeyName.USER);
    }
}
