package model;

import java.util.ArrayList;

public class MenuProduct extends Product{
    private ArrayList<Product> products;

    public MenuProduct(String name, ArrayList<Product> products) {
        super(name);

        this.products = products;
    }
    public double calculateExpense(){
        double expense = 0;

        for(Product product : products){
            expense += product.calculateExpense();
        }
        return expense;
    }

    public double getSellingPrice(){
        double total = 0;

        for (Product product : products) {
          if (product instanceof MainDish) {
            total += product.getSellingPrice() * 0.9;
          } else if (product instanceof Dessert) {
            total += product.getSellingPrice() * 0.8;
          } else if (product instanceof Beverage) {
            total += product.getSellingPrice() * 0.5;
          }
        }

        return total;
    }
}
