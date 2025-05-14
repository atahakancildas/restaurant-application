import java.util.ArrayList;
import java.util.Scanner;

import model.*;

public class Main {
  public static void main(String[] args) {
    Restaurant restaurant = new Restaurant();
    Scanner scanner = new Scanner(System.in);

    int menuState = 0;

//  State 0 -> Main Menu
//  State 1 -> Create Order
//  State 2 -> Manage Restaurant

    while(true){
      if(menuState == 0){
        System.out.println("Welcome to OZU Restaurant! \n" + "-".repeat(15) + " Main Menu " + "-".repeat(15));
        System.out.println("1: Create Order \n2: Manage Restaurant \n3: Exit Program");
        System.out.println("-".repeat(40));
        System.out.print(">> ");

        try {
          int choice = Integer.parseInt(scanner.nextLine());

          if(choice == 1){
            menuState = 1;
          } else if(choice == 2){
            menuState = 2;
          } else if(choice == 3){
            System.out.println("Bye!");

            scanner.close();
            break;
          } else {
            throw new Exception("Please choose a valid option!");
          }
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      } else if(menuState == 1){
        Order newOrder = new Order();

        Waiter waiter = restaurant.assignWaiter();
        System.out.println("Hi, I'm " + waiter.getName() + ".\nI will be your waiter today!\nWhat would you like to get today?");

        while (true) {
          try {
            System.out.println("-".repeat(15) + " Create Order " + "-".repeat(15));
            System.out.println("1: List Order \n2: Add Product \n3: Complete Order \n4: Go back to Main Menu");
            System.out.println("-".repeat(40));
            System.out.print(">> ");

            int choice = Integer.parseInt(scanner.nextLine());

            if(choice == 1){
              if (newOrder.getOrderedProducts().size() == 0) {
                System.out.println("You have not ordered anything yet!");
              } else {
                newOrder.listOrder();
              }
            } else if(choice == 2){
              ArrayList<Product> products = restaurant.getProducts();

              for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ": " + products.get(i).getName());
              }

              try {
                System.out.print(">> ");
                int productIndex = Integer.parseInt(scanner.nextLine());

                Product product = products.get(productIndex - 1);
                newOrder.addProduct(product);

                ArrayList<Product> orderedProducts = newOrder.getOrderedProducts();

                for (Product orderedProduct : orderedProducts) {
                  System.out.println(orderedProduct.getName() + ": " + orderedProduct.getSellingPrice());
                }
              } catch (Exception e) {
                throw new Exception("Please choose a valid option!");
              }

            }  else if(choice == 3) {
              ArrayList<Product> orderedProducts = newOrder.getOrderedProducts();

              if (orderedProducts.size() == 0) {
                System.out.println("You have not ordered anything yet!");
              } else {
                System.out.println("Your order is complete!\nReturning to Main Menu");

                waiter.createOrder(newOrder);

                menuState = 0;
                break;
              }
            } else if (choice == 4){
              System.out.println("Returning to Main Menu");

              menuState = 0;
              break;
            } else {
              throw new Exception("Please choose a valid option!");
            }
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
        }
      } else if (menuState == 2) {
        System.out.println("-".repeat(15) + " Manage Restaurant " + "-".repeat(15));
        System.out.println("1: List Employees \n2: Add Employee \n3: Calculate Expenses \n4: Calculate Revenue \n5: Go back to Main Menu");
        System.out.println("-".repeat(40));
        System.out.print(">> ");

        try {
          int choice = Integer.parseInt(scanner.nextLine());

          if(choice == 1){
            restaurant.listEmployees();
          } else if(choice == 2){
            while(true){
              System.out.println("-".repeat(15) + " Add Employee " + "-".repeat(15));
              System.out.println("1: Add Cook \n2: Add Waiter \n3: Go back to Manage Restaurant Menu");
              System.out.println("-".repeat(40));
              System.out.print(">> ");

              try {
                int subChoice = Integer.parseInt(scanner.nextLine());

                if(subChoice == 1){
                  System.out.println("Name of the Cook:");
                  System.out.print(">> ");
                  String name = scanner.nextLine();

                  System.out.println("Salary of the Cook:");
                  System.out.print(">> ");
                  double salary = Double.parseDouble(scanner.nextLine());

                  restaurant.addCook(name, salary);

                  System.out.println("Added a new cook!");
                } else if(subChoice == 2){
                  System.out.println("Name of the Waiter:");
                  System.out.print(">> ");
                  String name = scanner.nextLine();

                  restaurant.addWaiter(name);

                  System.out.println("Added a new waiter!");
                } else if(subChoice == 3){
                  break;
                } else {
                  throw new Exception("Please choose a valid option!");
                }
              } catch (Exception e) {
                System.out.println(e.getMessage());
              }
            }
          } else if(choice == 3){
            double orderExpenses = 0;

            for (Employee employee : restaurant.getEmployees()) {
              if (employee instanceof Waiter) {
                ArrayList<Order> ordersReceived = ((Waiter) employee).getOrdersReceived();

                for (Order order : ordersReceived) {
                  orderExpenses += order.calculateTotalExpense();
                }
              }
            }

            System.out.println("Employee Expenses: " + restaurant.calculateExpenses());
            System.out.println("Order Expenses: " + orderExpenses);
            System.out.println("Total Expenses: " + (restaurant.calculateExpenses() + orderExpenses));
          } else if(choice == 4){
            System.out.println("Total Revenue: " + restaurant.calculateRevenue());
          } else if(choice == 5){
            menuState = 0;
          } else {
            throw new Exception("Please choose a valid option!");
          }
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      }
    }
  }
}
