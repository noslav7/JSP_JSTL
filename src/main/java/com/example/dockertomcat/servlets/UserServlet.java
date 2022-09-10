package com.example.dockertomcat.servlets;

import com.example.dockertomcat.model.User;
import com.example.dockertomcat.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import org.apache.commons.lang3.StringUtils;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] users = new String[]{"Tom", "Bob", "Sam"};
        request.setAttribute("users", users);
        request.setAttribute("val", 3);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
