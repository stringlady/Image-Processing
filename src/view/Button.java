package view;

import java.awt.*;

import javax.swing.*;

public class Button extends JButton {

  public Button(String operation) {
    super(operation);
    this.setPreferredSize(new Dimension(97, 48));
    this.setFont(new Font("Calibri",Font.PLAIN,14));
    this.setFocusPainted(false);
    this.setMargin( new Insets(20, 20, 20, 20) );
  }




}
