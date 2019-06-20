package xjtucad.controller;

import xjtucad.SSOManager;
import xjtucad.manager.ITokenManager;
import xjtucad.util.KeyName;
import xjtucad.util.SSOUtil;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class Logout extends HttpServlet {
    SSOManager ssoManager = SSOManager.getInstance();
    ITokenManager tokenManager = ssoManager.getTokenManager();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String auToken = (String) session.getAttribute("AU_TOKEN");
        //如果当前Session中存在登录信息，那么清除Session中的用户信息和对应的Token信息
        if(auToken!=null){
            tokenManager.removeUserInfo(auToken);
            session.removeAttribute(KeyName.TOKEN);
            session.removeAttribute(KeyName.USER);
        }
        //无论是否存在用户信息，都清除一下Cookie中的Token信息
        SSOUtil.clearToken(req,resp);
    }
}
