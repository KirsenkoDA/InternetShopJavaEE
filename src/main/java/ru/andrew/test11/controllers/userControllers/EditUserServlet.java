package ru.andrew.test11.controllers.userControllers;
import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "editUserServlet", value = "/edit-user-servlet")
public class EditUserServlet  extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("id"));
        String userName = req.getParameter("user_name");
        String birthDate = req.getParameter("birthdate");
        PrintWriter pw = resp.getWriter();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestDB", "postgres", "1976");
            PreparedStatement pstmt = conn.prepareStatement("UPDATE user_table SET user_name = (?) WHERE id = (?);");
            pstmt.setString(1, userName);
            pstmt.setInt(2, userId);
            pstmt.executeUpdate();
            pstmt.close();
            resp.sendRedirect("/user-servlet");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
