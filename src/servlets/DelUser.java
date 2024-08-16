package servlets;

import Impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DelUser.do")
public class DelUser extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        int Id =Integer.parseInt(req.getParameter("id"));
        UserDaoImpl udi = new UserDaoImpl();
        int i = udi.delete(Id);
        if(i>0){
            out.print("<script>alert('删除成功！');location.href='refresh.jsp'</script>");
        }
    }
}
