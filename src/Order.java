import java.util.ArrayList;

//Represents a customer's order, which can contain multiple products.
 
public class Order {

// List to store the products added to this order
private ArrayList<Product> products = new ArrayList<>();


//Adds a product to the order. 
public void addProduct(Product product) {
    this.products.add(product);
}

/**
 * Prints out the details of the order.
 * If no products have been added yet, notifies the user.
 */
public void listOrder() {
    if (this.products.isEmpty()) {
        // No products in the order
        System.out.println("You have not ordered anything yet!");
    } else {
        // Iterate through each product and print its name and price
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.println(p.getName() + " - " + p.getSellingPrice());
        }
    }
}




}