package servlets;

import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/Home.do")
public class Home extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        User u1 = null;
        if(user!=null) {
            u1=(User)user;
        }
        if(u1!=null){
            resp.setHeader("refresh","3;URL=home.html");
        }
        else{
            out.println("请登录后再访问，3秒钟后将跳到登录页面");
            resp.setHeader("refresh","3;URL=login.html");
        }
    }
}
