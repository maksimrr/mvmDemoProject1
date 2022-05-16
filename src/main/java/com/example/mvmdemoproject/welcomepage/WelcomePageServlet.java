package com.example.mvmdemoproject.welcomepage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.nio.charset.StandardCharsets;

//сервлет, принимающий GET запрос и перенаправляющий пользователя на страницу welcome.html

@WebServlet("/welcome")
public class WelcomePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/view/html-src/welcome.html").forward(req,resp);
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
    }

}
