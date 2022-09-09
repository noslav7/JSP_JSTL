package com.example.dockertomcat.servlets;

import com.example.dockertomcat.model.User;
import com.example.dockertomcat.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("message", "<script>alert('Hello gold')</script>");
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
