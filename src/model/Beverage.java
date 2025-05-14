package model;

public class Beverage extends Product{
    public Beverage(String name, double purchasePrice, double sellingPrice) {
      super(name, purchasePrice, sellingPrice);
    }

    public double calculateExpense() {
      return super.getPurchasePrice();
    }
}
