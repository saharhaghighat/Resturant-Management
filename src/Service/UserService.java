package Service;

import database.Database;
import enums.UserType;
import exception.CustomException;
import exception.InvalidPass;
import exception.NotfoundUser;
import model.Admin;
import model.Customer;
import model.User;

import java.util.Objects;

public class UserService {
    public void register(UserType type, String name, String nationalCode, String password) {
        User newUser;
        if (type.equals(UserType.ADMIN))
            newUser = new Admin(name, nationalCode, password);
        else
            newUser = new Customer(name, nationalCode, password);

        Database.AddUser(newUser);
    }

    public User login(UserType type, String username, String password) {
        User user = findByUsername(username);
        if (type.equals(UserType.ADMIN)) {
            if (user instanceof Admin) {
                if (user.validation(password)) {
                    return user;
                } else
                    throw new InvalidPass();
            }

            throw new CustomException("you can't Login as an admin!");
        } else if (user.validation(password)) {
            return user;
        } else throw new InvalidPass();
    }

    public User findByUsername(String Username) {
        for (int i = 0; i < Database.getUsers().length; i++)
            if (Objects.nonNull(Database.getUsers()[i]))
                if (Database.getUsers()[i].getNationalCode().equals(Username))
                    return Database.getUsers()[i];


        throw new NotfoundUser("not Found!");

    }

}
