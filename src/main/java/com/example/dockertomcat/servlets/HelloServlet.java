package com.example.dockertomcat.servlets;

import com.example.dockertomcat.model.User;
import com.example.dockertomcat.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<User> userList = userService.getUsers();

            request.setAttribute("name", userList.get(0).getName());
            request.setAttribute("age", 34);

            getServletContext().getRequestDispatcher("/basic.jsp").forward(request, response);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
