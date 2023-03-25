package model;

public class Customer extends User {
   private Order[] orderList;


    public Customer(String name, String nationalCode, String password) {
        super(name, nationalCode, password);

    }

    public void setOrderList(Order[] orderList) {
        this.orderList = orderList;
    }

    public Order[] getOrderList() {
        return orderList;
    }
}
