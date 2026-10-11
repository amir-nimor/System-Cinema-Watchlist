package ir.maktabsharif.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.maktabsharif.dto.user.UserDtoRequest;
import ir.maktabsharif.dto.user.UserDtoResponse;
import ir.maktabsharif.service.user.UserServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "RegistrationUser",value = "/RegistrationUser")
public class UserRegestrationServlet extends HttpServlet {

    private UserServiceImpl userService;

    private ObjectMapper objectMapper ;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.userService = (UserServiceImpl) getServletContext().getAttribute("userService");
        this.objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("./page/RegistrationUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        UserDtoRequest userDtoRequest = new UserDtoRequest(username,email,password);

        UserDtoResponse userDtoResponse = userService.save(userDtoRequest);

        session.setAttribute("user",userDtoResponse);

        resp.setStatus(201);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String json = objectMapper.writeValueAsString(userDtoResponse);
        resp.getWriter().write(json);
    }
}
