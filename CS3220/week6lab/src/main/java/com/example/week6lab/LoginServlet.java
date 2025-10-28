package com.example.week6lab;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        List<User> userList = (List<User>) getServletContext().getAttribute("userList");

        if (userList != null) {
            for (User user : userList) {
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);

                    response.sendRedirect("List-Tickets");
                    return;
                }
            }
        }
        response.sendRedirect("index.jsp?error=invalid");
    }
}
