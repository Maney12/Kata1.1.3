package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao createDao = new UserDaoJDBCImpl();
    public void createUsersTable() {
        createDao.createUsersTable();
    }

    public void dropUsersTable() {
        createDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        createDao.saveUser(name, lastName, age);
        System.out.printf("User с именем - %s добавлен в базу данных\n",name);
    }

    public void removeUserById(long id) {
        createDao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return createDao.getAllUsers();
    }

    public void cleanUsersTable() {
        createDao.cleanUsersTable();
    }
}
