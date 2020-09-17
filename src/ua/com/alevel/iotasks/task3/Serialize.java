package ua.com.alevel.iotasks.task3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Serialize {

    public void serialize(User user) {
        File file = new File("USER_" + user.getName().toUpperCase() + ".dat");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User deserialize(String name) throws FileNotFoundException {
        File file = new File("USER_" + name.toUpperCase() + ".dat");
        User user = new User();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            user = (User) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new FileNotFoundException("User " + name + " not found");
        }
        return user;
    }
}
