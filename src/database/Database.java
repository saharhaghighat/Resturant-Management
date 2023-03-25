package database;

import model.Food;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Database {
    private static List<Food> foods=new ArrayList<>(30);
    private static User[] users=new User[100];

    public static List<Food> getFoods() {
        return foods;
    }

    public static User[] getUsers() {
        return users;
    }


    public static  void AddFood(Food food){
        for (int i = 0; i < 30; i++) {
            if (Objects.isNull(foods.get(i)) )
                foods.add(food);
                break;
        }
    }
    public static void AddUser(User user){
        for (int i = 0; i < users.length; i++) {
            if (Objects.isNull(users[i]))
                users[i]=user;
                break;
        }
    }

}
