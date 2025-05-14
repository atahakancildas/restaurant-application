import java.util.ArrayList;
import java.util.List;

public class Waiter extends Employee {
    private static final double COMMISSION_RATE = 0.10; // 10% commission
    private List<Order> ordersReceived;

    public Waiter(int id, String name) {
        super(id, name);
        this.ordersReceived = new ArrayList<>();
    }

    public void createOrder(Order order) {
        ordersReceived.add(order);
    }

    public List<Order> getOrdersReceived() {
        return new ArrayList<>(ordersReceived);
    }

    @Override
    public double getSalary() {
        return calculateExpense();
    }

    @Override
    public double calculateExpense() {
        double totalCommission = 0;
        for (Order order : ordersReceived) {
            totalCommission += order.getTotalPrice() * COMMISSION_RATE;
        }
        return totalCommission;
    }
}
