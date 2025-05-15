package controller;

import model.Order;
import model.Product;
import model.Waiter;
import view.CreateOrderButtonPanel;
import view.CreateOrderPanel;
import view.OrderView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderController {
  private Order order;
  private OrderView view;
  private CreateOrderButtonPanel createOrderButtonPanel;
  private CreateOrderPanel createOrderPanel;
  private Waiter assignedWaiter;

  private RestaurantController restaurantController = new RestaurantController();

  public OrderController(OrderView orderView) {
    this.view = orderView;
    this.createOrderButtonPanel = view.getCreateOrderButtonPanel();
    this.createOrderPanel = view.getCreateOrderPanel();

    createOrderButtonPanel.setCreateOrderButtonListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        RestaurantController restaurantController = new RestaurantController();

        order = new Order();
        assignedWaiter = restaurantController.assignWaiter();

        CardLayout cardLayout = (CardLayout) view.getLayout();
        cardLayout.show(view, "createOrderPanel");

        JOptionPane.showMessageDialog(view, "Hi, I am " + assignedWaiter.getName() + ".\n" + "What would you like to order?");
      }
    });

    createOrderPanel.setProductComboBoxListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String productName = createOrderPanel.getSelectedProduct();

        Product product = restaurantController.getProductByName(productName);
        ;
        createOrderPanel.setPrice(product.getSellingPrice());
      }
    });

    createOrderPanel.setAddProductButtonListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String productName = createOrderPanel.getSelectedProduct();
        int count = createOrderPanel.getCount();
        double price = createOrderPanel.getPrice();

        Product product = restaurantController.getProductByName(productName);

        for (int i = 0; i < count; i++) {
          order.addProduct(product);
        }

        JTable orderTable = createOrderPanel.getOrderTable();
        DefaultTableModel tableModel = (DefaultTableModel) orderTable.getModel();
        tableModel.addRow(new Object[]{product.getName(), count, price * count});

        createOrderPanel.clearInputs();

        JButton finalizeButton = createOrderPanel.getFinalizeButton();

        finalizeButton.setEnabled(true);
      }
    });

    createOrderPanel.setFinalizeButtonListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(view, "Your order is completed!\nTotal price is " + order.calculateTotalPrice() + "TL");

        assignedWaiter.createOrder(order);

        createOrderPanel.clearInputs();
        createOrderPanel.clearTable();

        JButton finalizeButton = createOrderPanel.getFinalizeButton();
        finalizeButton.setEnabled(false);

        CardLayout cardLayout = (CardLayout) view.getLayout();
        cardLayout.show(view, "createOrderButtonPanel");
      }
    });
  }
}
