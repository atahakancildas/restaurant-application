package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CreateOrderButtonPanel extends JPanel {
  private JButton createOrderButton;

  public CreateOrderButtonPanel(){
    createOrderButton = new JButton("Create Order");
    JPanel buttonPanel = new JPanel();

    buttonPanel.add(createOrderButton);

    add(buttonPanel);
  }

  public void setCreateOrderButtonListener(ActionListener listener) {
    createOrderButton.addActionListener(listener);
  }
}
