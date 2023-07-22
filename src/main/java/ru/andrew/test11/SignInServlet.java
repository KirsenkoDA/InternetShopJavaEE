package ru.andrew.test11;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet(name = "signInServlet", value = "/sign-in-user-servlet")
public class SignInServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        PrintWriter pw = resp.getWriter();

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestDB", "postgres", "1976");
            Statement stmt = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement("SELECT id FROM user_table WHERE user_login = ? AND user_password = ?;");
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                //pw.println("You have successfully logged in to your account");
                HttpSession session = req.getSession();
                session.setAttribute("user_id", rs.getInt("id"));
                resp.sendRedirect("/main-servlet");
            }
            else {
                pw.println("Error, data entered incorrectly");
                pw.println("<a href = \"static/form.html\"><button> Sign Up? </button></a>");
            }
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
