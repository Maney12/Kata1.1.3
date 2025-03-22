package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соединения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/test_schema";
    private static final String USER = "root";
    private static final String PASSWORD = "KataRoot22"; // Укажи свой пароль

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка подключения к БД", e);
        }
    }

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            System.out.printf("Успешное подключение к БД");
            connection.close();
        } catch (SQLException e) {
            System.out.printf("Ошибка подключения к БД", e);
        }
    }


}
