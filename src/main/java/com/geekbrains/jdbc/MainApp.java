package com.geekbrains.jdbc;

import java.sql.*;

public class MainApp {
    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
       try {
           connect();

           addUser("Bob 32 bob@gmail.com");

           deleteUser("Bob");

           selectAllUsers();

           showUsersByAge(25, 40);

       } catch (SQLException e) {
           e.printStackTrace();
       }
       finally {
           disconnect();

       }

    }

    private static void showUsersByAge(final Integer min, final Integer max) throws SQLException {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE age BETWEEN " + min + " AND " + max);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void selectAllUsers() throws SQLException {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteUser(final String name) throws SQLException {
        statement.executeUpdate("DELETE FROM users WHERE name = '" + name + "'");
    }

    private static void addUser(final String row) throws SQLException {
        String[] parts = row.split(" ");
        statement.executeUpdate("INSERT INTO users (name, age, email) VALUES ('" + parts[0] + "', " + parts[1] + ", '" + parts[2] + "')");
    }

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:jdbc.db");
            statement = connection.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to connect to database");
        }

    }
    public static void disconnect() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
