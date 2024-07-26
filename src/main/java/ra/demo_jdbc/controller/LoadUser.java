package ra.demo_jdbc.controller;

import ra.demo_jdbc.entity.User;
import ra.demo_jdbc.service.impl.UserServiceImpl;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LoadUser", value = "/LoadUser")
public class LoadUser extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        List<User> all = new UserServiceImpl().findAll();
        request.setAttribute("list",all);
        request.getRequestDispatcher("listUser.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        doGet(request,response);
    }
    public void destroy() {
    }
}