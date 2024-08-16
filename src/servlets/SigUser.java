package servlets;

import Impl.UserDaoImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SigUser.do")
public class SigUser extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int Id =Integer.parseInt(req.getParameter("id"));
        UserDaoImpl udi = new UserDaoImpl();
        User user1 = new User();
        user1 = udi.selectById(Id);
        req.setAttribute("user1",user1);
        req.getRequestDispatcher("info.jsp").forward(req,resp);
    }
}
