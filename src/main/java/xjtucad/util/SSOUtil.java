package xjtucad.util;

import xjtucad.model.Result;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.stream.Collectors;

public class SSOUtil {
    public static void clearToken(HttpServletRequest request, HttpServletResponse response) {

        Cookie tokenCookie = new Cookie(KeyName.TOKEN, "");
        tokenCookie.setMaxAge(0);
        tokenCookie.setPath("/");

        Cookie userInfoCookie = new Cookie(KeyName.COOKIE_USER_INFO, "");
        userInfoCookie.setMaxAge(0);
        userInfoCookie.setPath("/");
        try {
            if (response != null) {
                response.addCookie(tokenCookie);
                response.addCookie(userInfoCookie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        if (request != null) {
            request.getSession().removeAttribute(KeyName.USER);
        }
    }


    public static String result2String(Result result) {
        StringBuilder sb = new StringBuilder().append('{');
        sb.append(getString("state")).append(':').append(result.isState() ? "true" : "false").append(',');
        sb.append(getString("content")).append(':').append(result.getContent()).append('}');
        return sb.toString();
    }

    public static String userMap2JSONString(Map<String, String> user) {
        StringBuilder sb = new StringBuilder().append('{');
        String m = user.entrySet().stream()
                .map(e -> getString(e.getKey()) + ':' + getString(e.getValue()))
                .collect(Collectors.joining(","));
        return sb.append(m).append('}').toString();
    }

    public static String getString(String string) {
        StringBuilder stringBuilder = new StringBuilder().append('"');
        stringBuilder.append(string).append('"');
        return stringBuilder.toString();
    }
}
