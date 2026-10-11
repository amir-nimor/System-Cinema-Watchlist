package ir.maktabsharif.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.maktabsharif.dao.UserDao;
import ir.maktabsharif.service.user.UserServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "Login",value = "/Login")
public class LoginServlet extends HttpServlet {

    private UserServiceImpl userService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.userService = (UserServiceImpl) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("./page/Login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDao userDao = userService.findByUsername(username);

        if (userDao.getPassword().equals(password)){
            session.setAttribute("user",userDao);
            req.setAttribute("user",userDao);
            req.getRequestDispatcher("./page/LoginSuccssfully.jsp").forward(req,resp);
            return;
        }else {
            resp.sendRedirect("./page/Login.jsp");
            return;
        }
    }
}
