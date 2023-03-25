package model;

import exception.InputPassword;

import java.text.ParseException;
import java.util.InputMismatchException;

public class Account {
    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length()>6)
         this.password = password;
    else

        throw  new InputPassword();
    }
    public boolean validatePass(String password){
        return this.password.equals(password);

    }

}
