import java.util.List;
import java.util.ArrayList;

public class Order {
    private List<Product> products;
    private double totalPrice;

    public Order() {
        this.products = new ArrayList<>();
        this.totalPrice = 0;
    }

    public void addProduct(Product product) {
        products.add(product);
        totalPrice += product.getSellingPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}
