package model;

public abstract class Product implements Expense {
    private String name;
    private double purchasePrice;
    private double sellingPrice;
    private double utilityCost;

    public Product(String name, double purchasePrice, double sellingPrice, double utilityCost) {
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.utilityCost = utilityCost;
    }

    public Product(String name, double purchasePrice, double sellingPrice) {
      this.name = name;
      this.purchasePrice = purchasePrice;
      this.sellingPrice = sellingPrice;
    }
    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    private void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getUtilityCost() {
        return utilityCost;
    }

    public abstract double calculateExpense();

    @Override
    public String toString() {
      return "Product :" + "\nName" + name + "\nPurchase Price: " + purchasePrice + "\nSelling Price: " + sellingPrice + "\nUtility Cost: " + utilityCost;
    }
}
