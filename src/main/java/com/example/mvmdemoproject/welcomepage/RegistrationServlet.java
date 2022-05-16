package com.example.mvmdemoproject.welcomepage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.mvmdemoproject.welcomepage.dbAccesService.Person;
import com.example.mvmdemoproject.welcomepage.dbAccesService.DbContentProcessing;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

/*
    Сервлет, принимающий в doPost параметры из формы с HTML - страницы registration.html.
    Инициирует создание записи в базе данных, содержащей значения введенных параметров.
    После создания записи перенаправляет пользователя на success.html
 */




@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/view/html-src/registration.html").forward(req,resp);
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            DbContentProcessing.createUser(Person.getInstance(
                    req.getParameter("first_name"),
                    req.getParameter("last_name"),
                    req.getParameter("birthday"),
                    req.getParameter("phone_number"),
                    req.getParameter("email"),
                    req.getParameter("adress")));
            req.getRequestDispatcher("WEB-INF/view/html-src/success.html").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
