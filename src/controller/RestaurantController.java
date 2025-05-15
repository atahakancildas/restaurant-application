package controller;

import model.*;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RestaurantController {
  public static final Restaurant restaurant = new Restaurant();
  private RestaurantView view;
  private ListEmployeesPanel listEmployeesPanel;
  private AddCookPanel addCookPanel;
  private AddWaiterPanel addWaiterPanel;
  private CalculateExpensesPanel calculateExpensesPanel;

  public RestaurantController() {}
  public RestaurantController(RestaurantView restaurantView) {
    this.view = restaurantView;

    listEmployeesPanel = view.getListEmployeesPanel();
    addCookPanel = view.getAddCookPanel();
    addWaiterPanel = view.getAddWaiterPanel();
    calculateExpensesPanel = view.getCalculateExpensesPanel();

    view.setListEmployeesButtonListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) view.getContentPanel().getLayout();

        listEmployeesPanel.updateTable();

        cardLayout.show(view.getContentPanel(), "listEmployeesPanel");
      }
    });

    view.setAddCookButtonListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) view.getContentPanel().getLayout();

        cardLayout.show(view.getContentPanel(), "addCookPanel");
      }
    });

    addCookPanel.setAddCookButtonListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String name = view.getAddCookPanel().getNameField().getText();

        String salary = view.getAddCookPanel().getSalaryField().getText();

        if (name.isEmpty() || salary.isEmpty()) {
          JOptionPane.showMessageDialog(view, "Please enter a valid name and salary.");

          return;
        }

        double parsedSalary = 0;
        try {
          parsedSalary = Double.parseDouble(salary);
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(view, "Please enter a valid salary.");

          return;
        }

        if (parsedSalary <= 0) {
          JOptionPane.showMessageDialog(view, "Please enter a valid salary.");

          return;
        }

        restaurant.addCook(name, parsedSalary);

        JOptionPane.showMessageDialog(view, "Cook added successfully.");

        view.getAddCookPanel().getNameField().setText("");
        view.getAddCookPanel().getSalaryField().setText("");
      }
    });

    view.setAddWaiterButtonListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) view.getContentPanel().getLayout();

        cardLayout.show(view.getContentPanel(), "addWaiterPanel");
      }
    });

    addWaiterPanel.setAddWaiterButtonListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String name = view.getAddWaiterPanel().getNameField().getText();

        if (name.isEmpty()) {
          JOptionPane.showMessageDialog(view, "Please enter a valid name.");

          return;
        }

        restaurant.addWaiter(name);

        JOptionPane.showMessageDialog(view, "Waiter added successfully.");

        view.getAddWaiterPanel().getNameField().setText("");
      }
    });

    view.setCalculateExpensesButtonListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) view.getContentPanel().getLayout();

        calculateExpensesPanel.calculateExpensesRevenueData();

        cardLayout.show(view.getContentPanel(), "calculateExpensesPanel");
      }
    });
  }

  public Waiter assignWaiter() {
    return restaurant.assignWaiter();
  }

  public ArrayList<Product> getProducts() { return restaurant.getProducts(); }

  public Product getProductByName(String name) {
    for (Product product : getProducts()) {
      if (product.getName().equals(name)) {
        return product;
      }
    }

    return null;
  }

  public ArrayList<Employee> getEmployees() { return restaurant.getEmployees(); }

  public static double calculateExpenses() {
    double orderExpenses = 0;

    for (Employee employee : restaurant.getEmployees()) {
      if (employee instanceof Waiter) {
        ArrayList<Order> ordersReceived = ((Waiter) employee).getOrdersReceived();

        for (Order order : ordersReceived) {
          orderExpenses += order.calculateTotalExpense();
        }
      }
    }

    return orderExpenses + restaurant.calculateExpenses();
  }

  public static double calculateRevenue() { return restaurant.calculateRevenue(); }

}
