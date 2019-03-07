package xjtucad.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import xjtucad.dao.UserDao;
import xjtucad.util.KeyName;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class User extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //当前的Get方法是列出所有的用户。
        UserDao userDao = new UserDao();
        Map<String,String> userInfo = (Map<String, String>) req.getSession().getAttribute(KeyName.USER);
        List<xjtucad.model.User> userList = userDao.getAllUserExceptMe(userInfo.get("username"));

        resp.setContentType("application/json,charset=UTF-8");
        resp.getWriter().write(JSON.toJSONString(userList));
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
