package Service;

import database.Database;
import exception.CustomException;
import model.Food;

public class AdminService {
    public void AddFood(String name,boolean Available,double price){
        Food food=new Food(name,price,Available);
        Database.AddFood(food);
    }
    public void changeFoodAvailability(Food food,boolean Available){
        if (food.isAvailable()==Available)
            throw new CustomException("this food's availability is already "+Available);
        food.setAvailable(Available);

    }
    public void changeFoodPrice(Food food,double price){
        food.setPrice(price);

    }
}
