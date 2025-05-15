package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddWaiterPanel extends JPanel {
  private JTextField nameField;
  private JButton addWaiterButton;

  public AddWaiterPanel() {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    JPanel inputPanel = new JPanel(new GridLayout(1, 2));
    inputPanel.setMaximumSize(new Dimension(800, 200));

    JPanel buttonPanel = new JPanel();

    nameField = new JTextField();
    addWaiterButton = new JButton("Add Waiter");

    inputPanel.add(new JLabel("Name:"));
    inputPanel.add(nameField);

    buttonPanel.add(addWaiterButton);

    add(inputPanel);
    add(buttonPanel);
  }

  public JTextField getNameField() {
    return nameField;
  }

  public void setAddWaiterButtonListener(ActionListener listener) {
    addWaiterButton.addActionListener(listener);
  }
}
