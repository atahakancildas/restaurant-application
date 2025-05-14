package model;

import java.util.ArrayList;

public class Restaurant {
  private ArrayList<Employee> employees;
  private ArrayList<Product> products;

  public Restaurant() {
    initEmployees();
    initProducts();
  }

  private void initEmployees() {
    employees = new ArrayList<>();

    addCook("Monica", 1000);
    addWaiter("Ross");
    addWaiter("Chandler");
    addCook("Joey", 1500);
  }

  private void initProducts(){
    products = new ArrayList<>();

    ArrayList<Product> kidsMenuProducts = new ArrayList<>();
    kidsMenuProducts.add(new MainDish("Hamburger", 50, 250, 20));
    kidsMenuProducts.add(new Dessert("Ice Cream", 30, 50, 10));
    kidsMenuProducts.add(new Beverage("Coke", 10, 40));

    addProduct(new MainDish("Steak", 100, 300, 10));
    addProduct(new MainDish("Pasta", 100, 200, 10));
    addProduct(new Dessert("Cake", 50, 80, 10));
    addProduct(new Dessert("Ice Cream", 30, 50, 10));
    addProduct(new Beverage("Coke", 10, 40));
    addProduct(new Beverage("Water", 5, 20));
    addProduct(new Beverage("Juice", 10, 35));
    addProduct(new MenuProduct("Kids Menu", kidsMenuProducts));
  }

  public void listEmployees(){
    for (Employee employee : employees) {
      System.out.println("Employee " + (employee.getId() + 1) + ": " + employee.getName());
    }
  }

  public void addCook(String name, double salary){
    Cook newCook = new Cook(employees.size(), name, salary);
    employees.add(newCook);
  }

  public void addWaiter(String name){
    Waiter newWaiter = new Waiter(employees.size(), name);
    employees.add(newWaiter);
  }

  public void addProduct(Product newProduct){
    products.add(newProduct);
  }

  public Waiter assignWaiter() {
    ArrayList<Waiter> waiters = new ArrayList<>();

    for (Employee employee : employees) {
      if (employee instanceof Waiter) {
        waiters.add((Waiter) employee);
      }
    }

    int randomWaiterIndex = (int) (Math.random() * waiters.size());

    return waiters.get(randomWaiterIndex);
  }

  public double calculateExpenses() {
    double total = 0;

    for (Employee employee : employees) {
      total += employee.calculateExpense();
    }

    return total;
  }

  public double calculateRevenue() {
    double total = 0;

    for (Employee employee : employees) {
      if (employee instanceof Waiter) {
        for (Order order : ((Waiter) employee).getOrdersReceived()) {
          total += order.calculateTotalPrice();
        }
      }
    }

    return total;
  }

  public ArrayList<Employee> getEmployees() { return employees; }

  public ArrayList<Product> getProducts() { return products; }
}

