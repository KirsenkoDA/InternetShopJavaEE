package ru.andrew.test11.dao;
import ru.andrew.test11.models.Invent;
import ru.andrew.test11.models.User;

import java.sql.*;
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

            PreparedStatement pstmt = conn.prepareStatement("SELECT id, user_name, birthdate, user_role, user_password, user_login FROM user_table;");
            ResultSet rs = pstmt.executeQuery();
            userList = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUser_name(rs.getString("user_name"));
                user.setBirthdate(rs.getString("birthdate"));
                user.setUser_role(rs.getInt("user_role"));
                user.setUser_password(rs.getString("user_password"));
                user.setUser_login(rs.getString("user_login"));
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

            PreparedStatement pstmt = conn.prepareStatement("SELECT id, user_name, birthdate, user_role, user_password, user_login FROM user_table WHERE id = ?;");
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUser_name(rs.getString("user_name"));
                user.setBirthdate(rs.getString("birthdate"));
                user.setUser_role(rs.getInt("user_role"));
                user.setUser_password(rs.getString("user_password"));
                user.setUser_login(rs.getString("user_login"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
