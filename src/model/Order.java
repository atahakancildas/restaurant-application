package model;

import java.util.ArrayList;

public class Order {
    private ArrayList<Product> orderedProducts;
    public Order() {
        this.orderedProducts = new ArrayList<>();
    }

    public void addProduct(Product product) {
        orderedProducts.add(product);
    }

    public void listOrder() {
      for (Product product : orderedProducts) {
        System.out.println(product.getName() + ": " + product.getSellingPrice());;
      }
    }

    public ArrayList<Product> getOrderedProducts() {
      return orderedProducts;
    }

    public double calculateTotalPrice() {
      double total = 0;

      for (Product product : orderedProducts) {
        total += product.getSellingPrice();
      }

      return total;
    }

    public double calculateTotalExpense() {
      double total = 0;

      for (Product product : orderedProducts) {
        total += product.calculateExpense();
      }

      return total;
    }
}
