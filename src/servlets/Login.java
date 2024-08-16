package servlets;

import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/doLogin.do")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String userName = req.getParameter("userName");
        String pwd = req.getParameter("pwd");
        HttpSession session = req.getSession();
        UserModel userModel = new UserModel();
        String filePath1 = "D:/IdeaProjects/ss2021121008_2/web/WEB-INF/users";

        //检查用户是否注册
        File userFile = new File(filePath1 + "/" + req.getParameter("userName") + ".properties");
        if(userModel.loginCheck(userFile,pwd)) {
            //session存储用户名
            session.setAttribute("user", userName);
            //创建cookie
            if(req.getParameter("autoLogin")!=null){
                Cookie cookie1 = new Cookie("cookieUName",userName);
                Cookie cookie2 = new Cookie("cookieUPwd",pwd);
                resp.addCookie(cookie1);
                resp.addCookie(cookie2);
            }
            out.println("登录成功，3秒钟后将跳到首页");
            resp.setHeader("refresh","3;URL=home.html");
        }
        else{
            out.println("登录失败，用户名或密码错误，3秒钟后将跳到登录页面");
            resp.setHeader("refresh","3;URL=login.html");
        }
}
}
