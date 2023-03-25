package model;

import Service.UserService;

import java.time.LocalDate;

public class Order {
  private Food food;
 private   LocalDate date;

    public Order(Food food) {
        this.food = food;
        this.date=LocalDate.now();

    }

}
