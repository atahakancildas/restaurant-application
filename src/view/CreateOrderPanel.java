package view;

import controller.RestaurantController;
import model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateOrderPanel extends JPanel {
  private JComboBox<String> productComboBox;
  private JSpinner countSpinner;
  private JLabel price;
  private JButton addProductButton;
  private JTable orderTable;
  private JButton finalizeButton;

  private RestaurantController restaurantController = new RestaurantController();

  public CreateOrderPanel() {
    JPanel inputPanel = new JPanel(new GridLayout(3, 2));
    inputPanel.setMaximumSize(new Dimension(800, 200));

    JPanel addProductButtonPanel = new JPanel();
    JPanel addProductPanel = new JPanel();
    addProductPanel.setLayout(new BoxLayout(addProductPanel, BoxLayout.Y_AXIS));

    JPanel finalizeButtonPanel = new JPanel();

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    productComboBox = new JComboBox<>();

    for (Product product : restaurantController.getProducts()) {
      productComboBox.addItem(product.getName());
    }

    countSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));

    price = new JLabel();
    price.setText(restaurantController.getProductByName(getSelectedProduct()).getSellingPrice() + "");

    addProductButton = new JButton("Add");

    inputPanel.add(new JLabel("Product:"));
    inputPanel.add(productComboBox);
    inputPanel.add(new JLabel("Count:"));
    inputPanel.add(countSpinner);
    inputPanel.add(new JLabel("Price:"));
    inputPanel.add(price);
    addProductButtonPanel.add(addProductButton);

    addProductPanel.add(inputPanel);
    addProductPanel.add(addProductButtonPanel);

    String[] columnNames = {"Product Name", "Count", "Price"};
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    orderTable = new JTable(tableModel);

    JScrollPane tableScrollPane = new JScrollPane(orderTable);
    tableScrollPane.setMaximumSize(new Dimension(800, 400));

    finalizeButton = new JButton("Finalize");
    finalizeButton.setEnabled(false);
    finalizeButtonPanel.add(finalizeButton);

    add(addProductPanel);
    add(tableScrollPane);
    add(finalizeButtonPanel);
  }

  public String getSelectedProduct() {
    return (String) productComboBox.getSelectedItem();
  }

  public int getCount() {
    return (int) countSpinner.getValue();
  }

  public void setPrice(double price) {
    this.price.setText(String.format("%.2f", price));
  }

  public double getPrice() {
    return Double.parseDouble(price.getText());
  }

  public JTable getOrderTable() {
    return orderTable;
  }

  public JButton getFinalizeButton() {
    return finalizeButton;
  }

  public void clearInputs() {
    productComboBox.setSelectedIndex(0);
    countSpinner.setValue(1);
    price.setText(restaurantController.getProductByName(getSelectedProduct()).getSellingPrice() + "");
  }

  public void clearTable() {
    DefaultTableModel tableModel = (DefaultTableModel) orderTable.getModel();
    tableModel.setRowCount(0);
  }

  public void setAddProductButtonListener(ActionListener listener) {
    addProductButton.addActionListener(listener);
  }

  public void setProductComboBoxListener(ActionListener listener) { productComboBox.addActionListener(listener); }

  public void setFinalizeButtonListener(ActionListener listener) { finalizeButton.addActionListener(listener); }
}
