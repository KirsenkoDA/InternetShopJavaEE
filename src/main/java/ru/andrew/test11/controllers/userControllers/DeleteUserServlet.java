package ru.andrew.test11.controllers.userControllers;
import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "deleteUserServlet", value = "/delete-user-servlet")
public class DeleteUserServlet  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("id"));
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestDB", "postgres", "1976");
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM user_table WHERE id = (?);");
            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
            pstmt.close();
            resp.sendRedirect("/user-servlet");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
