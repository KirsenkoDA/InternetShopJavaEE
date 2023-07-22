package ru.andrew.test11.controllers.userControllers;
import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "userServlet", value = "/controllers/userControllers/user-servlet")
public class UserServlet extends HttpServlet{

    @Override
    //Добавление нового пользователя
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    //Вывод карточки пользователя
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        pw.println("<html><body>");

        int userId;
        if(req.getParameter("id") == null)
        {
            userId = 0;
        }
        else
        {
            userId = Integer.parseInt(req.getParameter("id"));
        }
        if(userId > 0)
        {
            pw.println("<h1>User Card</h1>");
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestDB", "postgres", "1976");

                PreparedStatement pstmt = conn.prepareStatement("SELECT id, user_name, birthdate FROM user_table WHERE id = ?");
                pstmt.setInt(1, userId);
                ResultSet rs = pstmt.executeQuery();
                if(rs.next())
                {
                    pw.print("<table border = \"1\">");
                    pw.print("<tr><th>User Id</th><th>User Name</th><th>User Birth Date</th><th>Edit</th><th>Delete</th></tr>");
                    pw.print("<tr>");
                    pw.println("<td>");
                    pw.println(rs.getInt("id"));
                    pw.println("</td>");
                    pw.println("<td>");
                    pw.println(rs.getString("user_name"));
                    pw.println("</td>");
                    pw.println("<td>");
                    pw.println(rs.getString("birthdate"));
                    pw.println("</td>");
                    pw.println("<td>");
                    pw.println("<a href = \"EditUserJSP.jsp?id=" + rs.getInt("id")+ "&user_name=" + rs.getString("user_name") + "\"> Edit</a>");
                    pw.println("</td>");
                    pw.println("<td>");
                    pw.println("<a href = \"delete-user-servlet?id=" + rs.getInt("id") + "\"> Delete </a>");
                    pw.println("</td>");
                    pw.print("</tr>");
                    pw.print("</table>");
                }
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            //Вывод полного списка пользователей

            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestDB", "postgres", "1976");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id, user_name FROM user_table");
                pw.println("<h1>User List </h1>");
                pw.print("<p align = \"right\"><a href = \"..\\..\\views\\users\\AddUsers.jsp\"><button> Add new user </button></a></p>");
                pw.print("<table border = \"1\">");
                pw.print("<tr><th>User Id</th><th>User Name</th><th>Card</th><th>Delete</th></tr>");
                while (rs.next()) {
                    pw.print("<tr>");
                    pw.println("<td>");
                    pw.print(rs.getInt("id"));
                    pw.println("</td>");
                    pw.println("<td>");
                    pw.print(rs.getString("user_name"));
                    pw.println("</td>");
                    pw.println("<td>");
                    pw.println("<a href = \"user-servlet?id=" + rs.getInt("id") + "\"> Card </a>");
                    pw.println("</td>");
                    pw.println("<td>");
                    pw.println("<a href = \"delete-user-servlet?id=" + rs.getInt("id") + "\"> Delete </a>");
                    pw.println("</td>");
                    pw.print("<tr>");
                }
                pw.println("<table>");
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        pw.println("</body></html>");
    }
}
