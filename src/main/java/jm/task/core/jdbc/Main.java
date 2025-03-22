package jm.task.core.jdbc;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService service = new UserServiceImpl();

        User user1 = new User("Alex", "Gordon", (byte) 22);
        User user2 = new User("Piter", "Parker", (byte) 33);
        User user3 = new User("Bruce", "Wayne", (byte) 44);
        User user4 = new User("Jackie", "Chan", (byte) 55);

        service.createUsersTable();

        service.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        service.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        service.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        service.saveUser(user4.getName(), user4.getLastName(), user4.getAge());


        System.out.println(service.getAllUsers());
        service.cleanUsersTable();
        service.dropUsersTable();


    }

}
