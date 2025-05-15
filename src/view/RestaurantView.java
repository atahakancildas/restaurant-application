package view;

import controller.RestaurantController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RestaurantView extends JPanel {
  private JButton listEmployeesButton;
  private JButton addCookButton;
  private JButton addWaiterButton;
  private JButton calculateExpensesButton;
  private JPanel contentPanel;
  private ListEmployeesPanel listEmployeesPanel;
  private AddCookPanel addCookPanel;
  private AddWaiterPanel addWaiterPanel;
  private CalculateExpensesPanel calculateExpensesPanel;

  public RestaurantView() {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    JPanel buttonGroupPanel = new JPanel();
    listEmployeesButton = new JButton("List Employees");
    addCookButton = new JButton("Add Cook");
    addWaiterButton = new JButton("Add Waiter");
    calculateExpensesButton = new JButton("Calculate Expenses");

    contentPanel = new JPanel(new CardLayout());
    JPanel initialPanel = new JPanel();

    listEmployeesPanel = new ListEmployeesPanel();
    addCookPanel = new AddCookPanel();
    addWaiterPanel = new AddWaiterPanel();
    calculateExpensesPanel = new CalculateExpensesPanel();

    RestaurantController restaurantController = new RestaurantController(this);

    contentPanel.add(initialPanel, "initialPanel");
    contentPanel.add(listEmployeesPanel, "listEmployeesPanel");
    contentPanel.add(addCookPanel, "addCookPanel");
    contentPanel.add(addWaiterPanel, "addWaiterPanel");
    contentPanel.add(calculateExpensesPanel, "calculateExpensesPanel");

    buttonGroupPanel.add(listEmployeesButton);
    buttonGroupPanel.add(addCookButton);
    buttonGroupPanel.add(addWaiterButton);
    buttonGroupPanel.add(calculateExpensesButton);

    add(buttonGroupPanel);
    add(contentPanel);
  }

  public JPanel getContentPanel() {
    return contentPanel;
  }

  public ListEmployeesPanel getListEmployeesPanel() {
    return listEmployeesPanel;
  }

  public AddCookPanel getAddCookPanel() {
    return addCookPanel;
  }

  public AddWaiterPanel getAddWaiterPanel() {
    return addWaiterPanel;
  }

  public CalculateExpensesPanel getCalculateExpensesPanel() {
    return calculateExpensesPanel;
  }

  public void setListEmployeesButtonListener(ActionListener listener) {
    listEmployeesButton.addActionListener(listener);
  }

  public void setAddCookButtonListener(ActionListener listener) {
    addCookButton.addActionListener(listener);
  }

  public void setAddWaiterButtonListener(ActionListener listener) {
    addWaiterButton.addActionListener(listener);
  }

  public void setCalculateExpensesButtonListener(ActionListener listener) {
    calculateExpensesButton.addActionListener(listener);
  }
}
