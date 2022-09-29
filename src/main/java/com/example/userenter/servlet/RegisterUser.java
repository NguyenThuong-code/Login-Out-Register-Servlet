package com.example.userenter.servlet;

import com.example.userenter.DB.DBConnect;
import com.example.userenter.dao.UserDAO;
import com.example.userenter.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterUser extends HttpServlet {
 private static final long serialVersionUID= 1L;
 private UserDAO userDAO;
 public void init(){
     userDAO=new UserDAO();
 }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String name=req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String phone= req.getParameter("phone");
            String address= req.getParameter("address");
            String check = req.getParameter("check");

            User us = new User();
            us.setName(name);
            us.setEmail(email);
            us.setPassword(password);
            us.setPhone(phone);
            us.setAddress(address);
            HttpSession session=req.getSession();
         if (check!=null) {
             userDAO = new UserDAO();
             boolean f2 = userDAO.checkUser(email);
             if (f2) {
                 boolean f = userDAO.registerUser(us);
                 if (f) {
                     //System.out.println("User Register Success..");
                     session.setAttribute("succMsg", "Registration Successfully");
                     resp.sendRedirect("login.jsp");
                 } else {
                     //System.out.println("Something wrong on server..");
                     session.setAttribute("failedMsg", "Something wrong on server..");
                     resp.sendRedirect("register.jsp");
                 }
             } else {
                 session.setAttribute("failedMsg", "User Existed");
                 resp.sendRedirect("register.jsp");
             }
         }else {
             //System.out.println("Please Check Agree Term &Condition");
             session.setAttribute("failedMsg", "Please Check Agree Term &Condition");
             resp.sendRedirect("register.jsp");
         }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        resp.sendRedirect("login.jsp");
    }
}
