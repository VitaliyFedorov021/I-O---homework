package ua.com.alevel.iotasks.task3;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private List<User> users = new ArrayList<>();

    @Override
    public void createUser(User user) {
        users.add(user);
    }

    @Override
    public List<User> getAll() {
        return users;
    }
}
