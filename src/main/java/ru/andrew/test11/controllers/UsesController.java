package ru.andrew.test11.controllers;
import ru.andrew.test11.dao.UserDAO;
import ru.andrew.test11.models.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "usersController", value = "/users-controller")
public class UsesController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        if(req.getParameter("id") != null) {
            //Вывод карточки товара
            User user;
            user = (User)userDAO.show(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("user", user);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/users/show.jsp");
            requestDispatcher.forward(req, resp);
        }
        else {
            //Вывод полного списка товаров
            List<User> userList;
            userList = userDAO.index();
            req.setAttribute("userList", userList);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/users/index.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        UserDAO userDAO = new UserDAO();
        String operationParm = (String)req.getParameter("operation");
        switch (operationParm){
            case "edit":
            case "add":
                user.setId(Integer.parseInt(req.getParameter("id")));
                user.setUser_name(req.getParameter("user_name"));
                user.setBirthdate(req.getParameter("birthdate"));
                break;
            case "delete":
                user.setId(Integer.parseInt(req.getParameter("id")));
                user.setUser_name(req.getParameter("user_name"));
                break;
        }
        switch (operationParm){
            case "edit":
                userDAO.edit(user);
                break;
            case "delete":
                userDAO.delete(user);
                break;
            case "add":
                userDAO.add(user);
                break;
        }
        resp.sendRedirect("/users-controller");
    }
}

