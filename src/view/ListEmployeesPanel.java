package view;

import controller.RestaurantController;
import model.Cook;
import model.Employee;
import model.Waiter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ListEmployeesPanel extends JPanel {
  private JTable employeeTable;
  private RestaurantController restaurantController = new RestaurantController();

  public ListEmployeesPanel() {
    ArrayList<Employee> employees = restaurantController.getEmployees();

    String[] columnNames = {"ID", "Name", "Position"};
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    employeeTable = new JTable(tableModel);

    JScrollPane employeeTableScrollPane = new JScrollPane(employeeTable);

    drawTable();

    add(employeeTableScrollPane);
  }

  public void updateTable() {
    drawTable();
  }

  public void drawTable() {
    ArrayList<Employee> employees = restaurantController.getEmployees();
    DefaultTableModel tableModel = (DefaultTableModel) employeeTable.getModel();
    tableModel.setRowCount(0);

    for (Employee employee : employees) {
      if (employee instanceof Waiter) {
        tableModel.addRow(new Object[]{employee.getId() + 1, employee.getName(), "Waiter"});
      } else if (employee instanceof Cook) {
        tableModel.addRow(new Object[]{employee.getId() + 1, employee.getName(), "Cook"});
      }
    }
  }
}
