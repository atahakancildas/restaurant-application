package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddCookPanel extends JPanel {
  private JButton addCookButton;
  private JTextField nameField;
  private JTextField salaryField;

  public AddCookPanel() {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    JPanel inputPanel = new JPanel(new GridLayout(2, 2));
    inputPanel.setMaximumSize(new Dimension(800, 200));

    JPanel buttonPanel = new JPanel();

    nameField = new JTextField();
    salaryField = new JTextField();
    addCookButton = new JButton("Add Cook");

    inputPanel.add(new JLabel("Name:"));
    inputPanel.add(nameField);
    inputPanel.add(new JLabel("Salary:"));
    inputPanel.add(salaryField);

    buttonPanel.add(addCookButton);

    add(inputPanel);
    add(buttonPanel);
  }

  public JTextField getNameField() {
    return nameField;
  }

  public JTextField getSalaryField() {
    return salaryField;
  }

  public void setAddCookButtonListener(ActionListener listener) {
    addCookButton.addActionListener(listener);
  }
}
