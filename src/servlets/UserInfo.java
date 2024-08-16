package servlets;

import Impl.UserDaoImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserInfo.do")
public class UserInfo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDaoImpl udi = new UserDaoImpl();
        List<User> list = udi.selectAll();
        req.setAttribute("list",list);
        req.getRequestDispatcher("users.jsp").forward(req,resp);
    }
}
