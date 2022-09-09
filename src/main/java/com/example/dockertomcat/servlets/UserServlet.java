package com.example.dockertomcat.servlets;

import com.example.dockertomcat.model.User;
import com.example.dockertomcat.service.UserService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<User> userList = userService.getUsers();
            String param = request.getParameter("userId");
            if (StringUtils.isNotBlank(param)) {
                User user = userList.get(Integer.parseInt(param) - 1);
                request.setAttribute("user", user);
            } else {
                User user = userList.get(0);
                request.setAttribute("user", user);
            }

            getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
