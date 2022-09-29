package com.example.userenter.servlet;

import com.example.userenter.dao.UserDAO;
import com.example.userenter.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID=1L;

    public UserLoginServlet(){}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email= req.getParameter("email");
        String password= req.getParameter("password");
        UserDAO userDAO=new UserDAO();
        try {
            User user = userDAO.checkLogin(email,password);
            String destPage="login.jsp";
            if(user != null){
                HttpSession session= req.getSession();
                session.setAttribute("user",user);
                destPage="home.jsp";
            }else {
                String message="Invalid email/password";
                req.setAttribute("message", message);
            }
            RequestDispatcher rd= req.getRequestDispatcher(destPage);
            rd.forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
