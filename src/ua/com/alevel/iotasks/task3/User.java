package ua.com.alevel.iotasks.task3;

import java.io.Serializable;
import java.math.BigInteger;

public class User implements Serializable {
    private String name;
    private String email;
    private BigInteger number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (isCorrectName(name)) {
            this.name = name;
        } else {
            throw new RuntimeException("Incorrect name");
        }
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User= " + name + ", email= " + email + ", phone= " + number;
    }

    public void setEmail(String email) {
        if (isCorrectEmail(email)) {
            this.email = email;
        } else {
            throw new RuntimeException("Incorrect email");
        }
    }

    public BigInteger getNumber() {
        return number;
    }

    public void setNumber(BigInteger number) {
        this.number = number;
    }

    private boolean isCorrectName(String name) {
        char[] nameSymbols = name.toCharArray();
        boolean res = true;
        for (int i = 0; i < nameSymbols.length; ++i) {
            if(!Character.isLetter(nameSymbols[i])) {
                res = false;
            }
        }
        return res;
    }

    private boolean isCorrectEmail(String email) {
        char[] emailSymbols = email.toCharArray();
        boolean res = true;
        if (!Character.isLetter(emailSymbols[0]) && !Character.isDigit(emailSymbols[0])) {
            res = false;
        }
        int count = 0;
        for (int i = 1; i < emailSymbols.length; ++i) {
            if (emailSymbols[i] == '@') {
                count++;
            }
        }
        if (count != 1) {
            res = false;
        }
        return res;
    }
}
