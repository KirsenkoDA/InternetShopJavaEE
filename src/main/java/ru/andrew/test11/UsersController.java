package ru.andrew.test11;
import ru.andrew.test11.dao.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.andrew.test11.models.User;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "usersController", value = "/users-contoller")
public class UsersController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        List<User> userList;
        userList = userDAO.index();
        req.setAttribute("userList", userList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/users/UserList.jsp");
        requestDispatcher.forward(req, resp);
    }
}
