package model;

import java.util.ArrayList;

public class Waiter extends Employee {
    private double orderRate;
    private ArrayList<Order> ordersReceived;

    public Waiter(int id, String name) {
        super(id, name);
        this.orderRate = 0.1;
        this.ordersReceived = new ArrayList<>();
    }

    public void createOrder(Order order) {
        ordersReceived.add(order);
    }

    public ArrayList<Order> getOrdersReceived() {
        return ordersReceived;
    }

    @Override
    public double calculateExpense() {
        double total = 0;

        for (Order order : ordersReceived) {
            total += order.calculateTotalPrice() * orderRate;
        }

        return total;
    }
}
