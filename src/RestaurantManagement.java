import Service.AdminService;
import Service.FoodService;
import Service.UserService;
import Utill.Util;
import database.Database;
import enums.UserType;
import model.Customer;
import model.Food;
import model.Order;
import model.User;

import java.util.Objects;

public class RestaurantManagement {

    UserService userService;

    FoodService foodService;

    AdminService adminService;
    private static final int ADMIN = 1;
    private static final int CUSTOMER = 2;
    private static final int Login = 1;
    private static final int Register = 2;
    private static final int FOODS = 1;
    private static final int ORDERFOOD = 2;

    private static final int ORDEREDFOOD = 3;
    private static final int EXIT = 0;
    private static final int ADDFOOD = 1;
    private static final int AVALABILITY = 2;
    private static final int CHANGEPRICE = 3;
    private static final int LOGOUT = 4;
    private int code=0;


    private User currentUser;
    private boolean isExist;

    public void run() {

        while (Objects.isNull(currentUser)) {
            MainMenu();
        }

        while (!isExist) {
            if (code==0){
                AdminMenu();
            }else {
                CustomerMenu();
            }
        }
    }


    public void MainMenu() {
        int Item=Util.IntInput("1-Admin" + "\n" + "2-Customer");
        switch (Item) {
            case ADMIN: {
                authenticationMenu(UserType.ADMIN);
                break;
            }
            case CUSTOMER: {
                authenticationMenu(UserType.CUSTOMER);
                break;
            }
        }
    }

    public void Register(UserType userType) {
        String name = Util.StringInput("Enter your name:");
        String NationalCode = Util.StringInput("Enter your NationalCode:");
        String password = Util.StringInput("Enter your password:");
        if (userType.equals(UserType.ADMIN))
            userService.register(UserType.ADMIN, name, NationalCode, password);
        if (userType.equals(UserType.CUSTOMER))
            userService.register(UserType.CUSTOMER, name, NationalCode, password);

    }

    public void Login(UserType userType) {
        String NationalCode = Util.StringInput("Enter your NationalCode:");
        String password = Util.StringInput("Enter your password:");
        if (userType.equals(UserType.ADMIN))
            userService.login(UserType.ADMIN, NationalCode, password);
        if (userType.equals(UserType.CUSTOMER))
            userService.login(UserType.ADMIN, NationalCode, password);
    }

    public void authenticationMenu(UserType userType) {
        int InputItem = Util.IntInput("1-Login" + "\n" + "2-Register");
        switch (InputItem) {
            case Login: {
                Login(userType);
                break;
            }
            case Register: {
                Register(userType);
                break;
            }
        }
    }

    public void AdminMenu() {
        int selectItem = Util.IntInput("""
                Select the item:
                1. Add Food
                2. Availability of foods
                3. Change price
                4.Logout
                0. Exit
                """);
        switch (selectItem) {
            case ADDFOOD: {
                AddFood();
                break;
            }
            case AVALABILITY: {
                Availability();
                break;

            }
            case CHANGEPRICE: {
                ChangePrice();
                break;

            }
            case LOGOUT: {
                currentUser = null;
                run();
                break;

            }
            case EXIT: {
                System.out.println("thank you, bye!");
                isExist = true;
                break;

            }
        }

    }





    public void CustomerMenu() {
        code=1;
        int selectItem = Util.IntInput("""
                Select the item:
                1. Foods
                2. Order Food
                3. Ordered Food
                4.Logout
                0. Exit
                """);
        switch (selectItem) {
            case FOODS: {
               foods();
               break;
            }
            case ORDERFOOD: {
                order();
                break;
            }


            case ORDEREDFOOD: {
                showOrderList();
                break;

            }
            case LOGOUT: {
                currentUser = null;
                run();
                break;

            }
            case EXIT: {
                System.out.println("thank you, bye!");
                isExist = true;
                break;

            }
        }

    }

    public void AddFood(){
        String name=Util.StringInput("Enter name of food");
        boolean available=Util.InputBoolean("Enter your availability with true or false");
        double price=Util.IntDouble("Enter the price");
        adminService.AddFood(name,available,price);
        System.out.println("done!");
    }
    public void Availability(){
        boolean availability=Util.InputBoolean("Enter the ability you want with true or false");
        int id=Util.IntInput("Enter id");
        Food food=foodService.FindFoodById(id);
        adminService.changeFoodAvailability(food,availability);
        System.out.println("done!");

    }
    public void ChangePrice(){
        double price=Util.IntDouble("Enter price you want");
        int id=Util.IntInput("Enter id");
        Food food=foodService.FindFoodById(id);
        adminService.changeFoodPrice(food,price);
        System.out.println("done!");
    }
    public void foods(){
        Database.getFoods();
    }

    public void order(){
        int id=Util.IntInput("Enter id");
        Customer customer=(Customer) currentUser;
        Food food=foodService.FindFoodById(id);
        Order order=new Order(food);
        Order[] orders=new Order[5];
        customer.setOrderList(orders);

        for (int i = 0; i <orders.length; i++) {
            if (Objects.isNull(orders[i])){
                orders[i]=order;
                break;
            }
            else
            throw new RuntimeException("\"you can't order anymore!\"");
        }

        }

        public void showOrderList(){
            Customer customer=(Customer) currentUser;
            System.out.println(customer.getOrderList());

        }



}


