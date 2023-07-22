package ru.andrew.test11.controllers.userControllers;
import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "addUserServlet", value = "/add-user-servlet")
public class AddUserServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("id"));
        String userName = req.getParameter("user_name");
        //Date birthDate = Date.valueOf(req.getParameter("birthdate"));

        PrintWriter pw = resp.getWriter();
        pw.println("Text In Post");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestDB", "postgres", "1976");
            //PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user_table(id, user_name, birthdate) VALUES (?, ?, ?)");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user_table(id, user_name) VALUES (?, ?)");
            pstmt.setInt(1, userId);
            pstmt.setString(2, userName);
            // pstmt.setDate(3, birthDate);
            pstmt.executeUpdate();
            pstmt.close();
            resp.sendRedirect("/user-servlet");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
