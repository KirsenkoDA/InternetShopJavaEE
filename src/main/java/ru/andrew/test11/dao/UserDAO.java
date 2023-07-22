package ru.andrew.test11.dao;
import ru.andrew.test11.models.User;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class UserDAO {
    public List<User> index() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<User> userList;
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestDB", "postgres", "1976");

            PreparedStatement pstmt = conn.prepareStatement("SELECT id, user_name, birthdate FROM user_table;");
            ResultSet rs = pstmt.executeQuery();
            userList = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUser_name(rs.getString("user_name"));
                user.setBirthdate(rs.getString("birthdate"));
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
    public User show(int userId) {
        User user = new User();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestDB", "postgres", "1976");

            PreparedStatement pstmt = conn.prepareStatement("SELECT id, user_name, birthdate FROM user_table WHERE id = ? ORDER BY user_name;");
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUser_name(rs.getString("user_name"));
                user.setBirthdate(rs.getString("birthdate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
    public void add(User user)
    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestDB", "postgres", "1976");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user_table(id, user_name, birthdate) VALUES (?, ?, ?)");
            pstmt.setInt(1, user.getId());
            pstmt.setString(2,user.getUser_name());
            pstmt.setDate(3, Date.valueOf(user.getBirthdate()));
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void edit(User user)
    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestDB", "postgres", "1976");
            PreparedStatement pstmt = conn.prepareStatement("UPDATE user_table SET user_name = ?, birthdate = ? WHERE id = ?;");
            pstmt.setInt(3, user.getId());
            pstmt.setString(1,user.getUser_name());
            pstmt.setDate(2, Date.valueOf(user.getBirthdate()));
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(User user)
    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestDB", "postgres", "1976");
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM user_table WHERE id = ?;");
            pstmt.setInt(1, user.getId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
