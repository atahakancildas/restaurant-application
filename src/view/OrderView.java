package view;

import controller.OrderController;

import javax.swing.*;

import java.awt.*;

public class OrderView extends JPanel {
  private CreateOrderButtonPanel createOrderButtonPanel;
  private CreateOrderPanel createOrderPanel;

  public OrderView() {
    createOrderButtonPanel = new CreateOrderButtonPanel();
    createOrderPanel = new CreateOrderPanel();

    OrderController orderController = new OrderController(this);

    setLayout(new CardLayout());


    add(createOrderButtonPanel, "createOrderButtonPanel");
    add(createOrderPanel, "createOrderPanel");
  }

  public CreateOrderPanel getCreateOrderPanel() {
    return createOrderPanel;
  }

  public CreateOrderButtonPanel getCreateOrderButtonPanel() {
    return createOrderButtonPanel;
  }
}


