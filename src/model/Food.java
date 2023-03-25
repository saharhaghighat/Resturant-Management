package model;

import java.util.Random;

public class Food {
    private String  name;
    private double Price;
    private boolean  Available ;
    private int id;

    public Food(String name, double price, boolean available) {
        Random random=new Random();
        this.id=random.nextInt(100);
        this.name = name;
        this.Price = price;
        Available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public boolean isAvailable() {
        return Available;
    }

    public void setAvailable(boolean available) {
        Available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", Price=" + Price +"T"+
                ", Available=" + Available +
                ", id=" + id +
                '}';
    }
}

