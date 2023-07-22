package ru.andrew.test11.dao;
import ru.andrew.test11.models.Invent;

import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

public class InventDAO {
    public List<Invent> index() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<Invent> inventList;
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestDB", "postgres", "1976");

            PreparedStatement pstmt = conn.prepareStatement("SELECT item_id, item_name, item_price, item_img FROM invent_table;");
            ResultSet rs = pstmt.executeQuery();
            inventList = new ArrayList<>();
            while (rs.next()) {
                Invent invent = new Invent();
                invent.setItem_id(rs.getInt("item_id"));
                invent.setItem_name(rs.getString("item_name"));
                invent.setItem_price(rs.getInt("item_price"));
                invent.setItem_img(rs.getString("item_img"));
                inventList.add(invent);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return inventList;
    }

    public Invent show(int itemId) {
        Invent invent = new Invent();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestDB", "postgres", "1976");

            PreparedStatement pstmt = conn.prepareStatement("SELECT item_id, item_name, item_price, item_img FROM invent_table WHERE item_id = ? ORDER BY item_id;");
            pstmt.setInt(1, itemId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                invent.setItem_id(rs.getInt("item_id"));
                invent.setItem_name(rs.getString("item_name"));
                invent.setItem_price(rs.getInt("item_price"));
                invent.setItem_img(rs.getString("item_img"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return invent;
    }
    public void add(Invent invent)
    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestDB", "postgres", "1976");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO invent_table(item_id, item_name, item_price, item_img) VALUES (?, ?, ?, ?)");
            pstmt.setInt(1, invent.getItem_id());
            pstmt.setString(2,invent.getItem_name());
            pstmt.setInt(3,invent.getItem_price());
            pstmt.setString(4,invent.getItem_img());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void edit(Invent invent)
    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestDB", "postgres", "1976");
            PreparedStatement pstmt = conn.prepareStatement("UPDATE invent_table SET item_name = ?, item_price = ?,item_img = ? WHERE item_id = ?;");
            pstmt.setInt(4, invent.getItem_id());
            pstmt.setString(1,invent.getItem_name());
            pstmt.setInt(2,invent.getItem_price());
            pstmt.setString(3,invent.getItem_img());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(Invent invent)
    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestDB", "postgres", "1976");
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM invent_table WHERE item_id = ?;");
            pstmt.setInt(1, invent.getItem_id());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}