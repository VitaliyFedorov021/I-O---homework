package ua.com.alevel.iotasks.task3;

import java.util.List;

public interface UserDao {
    void createUser(User user);
    List<User> getAll();
}
