package xjtucad.controller;

import xjtucad.SSOManager;
import xjtucad.manager.ITokenManager;
import xjtucad.model.Result;
import xjtucad.util.KeyName;
import xjtucad.util.SSOUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenSync extends HttpServlet {
    SSOManager ssoManager = SSOManager.getInstance();
    ITokenManager tokenManager = ssoManager.getTokenManager();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Result result = new Result();
        String callback = req.getParameter("callback");
        String auToken = (String) req.getSession().getAttribute(KeyName.TOKEN);
        if(auToken!=null){
            //如果存在token，那么说明用户已经登录
            result.content = auToken;
            result.state = true;
        }else {
            result.state=false;
        }
        resp.getWriter().write(callback + "(" + SSOUtil.result2String(result) + ")");
        resp.getWriter().close();
    }
}
