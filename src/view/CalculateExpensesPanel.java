package view;

import controller.RestaurantController;

import javax.swing.*;
import java.awt.*;

public class CalculateExpensesPanel extends JPanel {
  private JPanel dataPanel;

  public CalculateExpensesPanel() {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    dataPanel = new JPanel(new GridLayout(3,2));
    dataPanel.setMaximumSize(new Dimension(800, 200));

    add(dataPanel);
  }

  public void calculateExpensesRevenueData() {
    double expenses = RestaurantController.calculateExpenses();
    double revenue = RestaurantController.calculateRevenue();

    dataPanel.removeAll();

    dataPanel.add(new JLabel("Expenses:"));
    dataPanel.add(new JLabel(Double.toString(expenses)));

    dataPanel.add(new JLabel("Revenue:"));
    dataPanel.add(new JLabel(Double.toString(revenue)));

    dataPanel.add(new JLabel("Profit:"));
    dataPanel.add(new JLabel(Double.toString(revenue - expenses)));
  }
}
