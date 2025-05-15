package view;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JPanel {
  public MenuView() {
    JTabbedPane tabbedPane = new JTabbedPane();
    tabbedPane.addTab("Order", new OrderView());
    tabbedPane.addTab("Restaurant", new RestaurantView());

    setLayout(new BorderLayout());
    add(tabbedPane, BorderLayout.CENTER);
  }
}
