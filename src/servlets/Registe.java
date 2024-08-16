package servlets;

import Impl.UserDaoImpl;
import entity.User;
import model.UserModel;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@MultipartConfig
@WebServlet("/register.do")
public class Registe extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        //新建user对象
        User user = new User();
        user.setUserName(req.getParameter("userName"));
        user.setPwd(req.getParameter("pwd"));
        user.setGender(req.getParameter("gender"));
        user.setCategory(req.getParameter("category"));
        user.setInterest(req.getParameter("interest"));

        //调用UserModel提供的registerUser方法
        UserModel userModel = new UserModel();
        String filePath1 = "D:/IdeaProjects/ss2021121008_2/web/WEB-INF/users";
        File userFile = new File(filePath1 + "/" + req.getParameter("userName") + ".properties");

        if (userModel.registerUser(userFile, user)) {

            //将用户上传的头像文件保存到upload
            Part part = req.getPart("photo");
            String fileName = part.getSubmittedFileName();
            user.setPhoto(fileName);
            String filePath2 = "D:/IdeaProjects/ss2021121008_2/web/WEB-INF/upload";
            part.write(filePath2 + "/" + fileName);
            //使用UserDaoImpl中的方法实现向t_user表中添加一条用户信息
            UserDaoImpl udi=new UserDaoImpl();
            int Id = 10;
            user.setId(Id);
            udi.save(user,Id);

            out.print("<script>alert('注册成功！');location.href='login.html'</script>");

        } else {
            out.println("注册失败！");
            resp.setHeader("refresh","3;URL=register.html");
        }
    }
}



