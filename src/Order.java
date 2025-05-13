import java.util.ArrayList;

/**
 * The Order class models a customer's order in the restaurant.
 * It maintains a list of Product instances, allows adding items,
 * printing the order, and computing the total price.
 */
public class Order {
    // ───────────────────────────────────────────────────────────────
    // Fields
    // ───────────────────────────────────────────────────────────────

    /**
     * Holds all products that have been added to this order.
     * Initialized in the constructor.
     */
    private ArrayList<Product> products;

    // ───────────────────────────────────────────────────────────────
    // Constructors
    // ──────────────────────────────────────────────────────────────

    /**
     * Creates a new, empty order.
     * After this constructor completes, the order contains zero products.
     */
    public Order() {
        // Initialize the internal list so we can store items
        products = new ArrayList<>();
    }


    /**
     * Adds the given product to this order.
     *
     *  the Product object to add (must not be null)
     */
    public void addProduct(Product product) {
        // Append to the end of the list
        products.add(product);
    }

    /**
     * Prints each ordered product's name and selling price to standard output.
     * If no products have been added, prints a message indicating the order is empty.
     */
    public void listOrder() {
        if (products.isEmpty()) {
            // No items in the order
            System.out.println("You have not ordered anything yet!");
        } else {
            // Loop through all products and print details
            for (Product p : products) {
                // Example output: "Cheeseburger 8.50"
                System.out.println(p.getName() + " " + p.getSellingPrice());
            }
        }
    }

    /**
     * Returns the list of products in this order.
     * Note: callers receive the actual internal list. If you need immutability,
     * consider returning a copy instead.
     *
     * @return the ArrayList of Product objects in the order
     */
    public ArrayList<Product> getOrderedProducts() {
        return products;
    }

    /**
     * Computes and returns the sum of the selling prices of all products
     * in this order.
     *
     * @return the total price as a double (0.0 if the order is empty)
     */
    public double calculateTotalPrice() {
        double total = 0.0;

        // Accumulate each product's price
        for (Product p : products) {
            total += p.getSellingPrice();
        }

        return total;
    }
}




