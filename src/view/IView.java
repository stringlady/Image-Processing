package view;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public interface IView {
  String getFileToLoad();
  void addActionListener(ActionListener listener);

  void setHist(Histogram[] hist);

  void displayImage(BufferedImage i);

  String getSaveDest();
}
