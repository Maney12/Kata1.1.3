package jm.task.core.jdbc.util;

import lombok.Getter;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соединения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/test_schema";
    private static final String USER = "root";
    private static final String PASSWORD = "KataRoot22";// Укажи свой пароль
    @Getter
    private static final SessionFactory sessionFactory;

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка подключения к БД", e);
        }
    }

    //Hibernate настройка конфигураций

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            configuration.setProperty("dialect", "org.hibernate.dialect.MySQL8Dialect");
            configuration.setProperty("hibernate.connection.url", URL);
            configuration.setProperty("hibernate.connection.username", USER);
            configuration.setProperty("hibernate.connection.password", PASSWORD);
            configuration.addAnnotatedClass(jm.task.core.jdbc.model.User.class);
            sessionFactory = configuration.buildSessionFactory();
            System.out.println("ОК");
        } catch (HibernateException e) {
            throw new RuntimeException("Ошибка конфигурации", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
