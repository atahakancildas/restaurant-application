package view;

import javax.swing.*;

public class MainWindow extends JFrame {
  public MainWindow() {
    setTitle("OZU Restaurant");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(800, 600);

    add(new MenuView());

    setVisible(true);
  }
}
