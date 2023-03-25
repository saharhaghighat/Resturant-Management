package Service;

import database.Database;
import exception.CustomException;
import exception.NotfoundUser;
import model.Food;

import java.util.Objects;

public class FoodService {
    public Food FindFoodById(int id){
        for (int i = 0; i < Database.getFoods().length; i++) {
            if ( Database.getFoods()[i].getId()==id)
                return Database.getFoods()[i];
        }
        throw new NotfoundUser("Not Found Food");

    }
public void checkAvailability(Food[] foods){

    for (int i = 0; i < foods.length; i++) {
        if (!foods[i].isAvailable())
            throw new CustomException(foods[i].getName()+"is not Available");
    }
}


}
