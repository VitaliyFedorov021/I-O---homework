package ua.com.alevel.iotasks.task3;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {
    UserDao userDao = new UserDaoImpl();
    Serialize serialize = new Serialize();
    private String input(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        String line = sc.nextLine();
        return line;
    }

    public void actionRun() {
        while(true) {
            String command = input("Enter the command");
            switch (command) {
                case "-create user": {
                    createUser();
                    for (User currentUser :
                            userDao.getAll()) {
                        serialize.serialize(currentUser);
                    }
                    continue;
                }
                case "-show": {
                    show();
                    continue;
                }
                case "-exit": {
                    System.exit(1);
                }
                default: {
                    System.out.println("Incorrect command, you can type " +
                            "\"-create user\", \"-show\", \"-exit\"");
                }
            }
        }
    }

    public void createUser() {
        User user = new User();
        String name = input("Enter the name"), email = input("Enter the email");
        String number = input("Enter the number");
        try {
            user.setNumber(new BigInteger(number));
            user.setName(name);
            user.setEmail(email);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            createUser();
        }
        userDao.createUser(user);
    }

    public void show() {
        String name = input("Enter the name of user");
        try{
             User user = serialize.deserialize(name);
             System.out.println(user.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            show();
        }
    }
}
