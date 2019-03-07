package xjtucad.filter;


import xjtucad.SSOManager;
import xjtucad.manager.ITokenManager;
import xjtucad.util.TokenUtil;
import xjtucad.util.KeyName;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Deprecated
public class TokenFilter implements Filter {
    SSOManager ssoManager = SSOManager.getInstance();

    ITokenManager tokenManager = ssoManager.getTokenManager();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpResponse =(HttpServletResponse)servletResponse;
        HttpSession session = httpRequest.getSession();
        String token=null;
        Cookie[] cookies = httpRequest.getCookies();
        if(cookies!=null&&cookies.length>0){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals(KeyName.TOKEN)){
                    token=cookie.getValue();
                    if(!tokenManager.containToken(token)){
                        token=null;
                    }
                    break;
                }
            }
        }
        if(token==null){
            //如果没有token，那么默认是退出状态
            TokenUtil.clearToken(httpRequest,httpResponse);
        }else {
            //如果有Token，认为不是退出状态
            session.setAttribute(KeyName.USER,tokenManager.getUserInfo(token));
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }



    @Override
    public void destroy() {

    }
}
