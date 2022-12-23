package view;


import java.awt.*;

import javax.swing.*;

import controller.ImageUtil;
import model.IImage;

public class Histogram extends JPanel {
  private final IImage image;

  private final int[] greenHeight;
  private final int[] redHeight;
  private final int[] blueHeight;

  private final int[] avgHeight;

  private int maximumCount;

  private int c;

  public Histogram(IImage image, int c) {
    this.image = image;
    this.c = c;

    this.setSize(new Dimension(256 ,256));
    this.setPreferredSize(new Dimension(256 ,256));

    this.greenHeight = new int[256];
    this.redHeight = new int[256];
    this.blueHeight = new int[256];
    this.avgHeight = new int[256];

    System.out.println(image.getHeight());
    model.Color[][] pixels = image.getPixels();
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        //barHeight[pixels[i][j].getRed()]++;
        redHeight[pixels[i][j].getRed()]++;
        greenHeight[pixels[i][j].getGreen()]++;
        blueHeight[pixels[i][j].getBlue()]++;
        int avg = (pixels[i][j].getRed() + pixels[i][j].getGreen() + pixels[i][j].getBlue()) / 3;
        avgHeight[avg]++;
      }
    }


    this.scaleBars(this.redHeight);
    this.scaleBars(this.greenHeight);
    this.scaleBars(this.blueHeight);
  }

  @Override
  public void paintComponent(Graphics g) {
    /**
     super.paintComponent(g);
     g.setColor(new Color(168, 165, 165));
     g.fillRect(20, 20, 512, 512);
     for (int i = 20; i < 532; i += 20) { // height
     for (int j = 20; j < 532; j++) { // width
     if (j % 2 == 0) {
     g.setColor(new Color(225, 220, 220));
     g.drawLine(j, i, j, i);
     g.drawLine(i, j, i, j);
     }
     }
     }

     for (int i = 0; i < 256; i++) {


     g.setColor(new Color(65, 175, 67, 100));
     g.fillRect(20 + i * 2, 532 - greenHeight[i] * 2, 2, greenHeight[i] * 2);

     g.setColor(new Color(176, 50, 50, 100));
     g.fillRect(20 + i * 2, 532 - redHeight[i] * 2, 2, redHeight[i] * 2);

     g.setColor(new Color(54, 86, 141, 100));
     g.fillRect(20 + i * 2, 532 - blueHeight[i] * 2, 2, blueHeight[i] * 2);
     }

     g.setColor(new Color(100, 97, 97));
     g.drawRect(20, 20, 512, 512);
     System.out.println("maxCount: " + maximumCount);
     */

    super.paintComponent(g);
    g.setColor(new Color(168, 165, 165));
    g.fillRect(0, 0, 256, 256);
    for (int i = 0; i < 256; i += 20) { // height
      for (int j = 0; j < 256; j++) { // width
        if (j % 2 == 0) {
          g.setColor(new Color(225, 220, 220));
          g.drawLine(j, i, j, i);
          g.drawLine(i, j, i, j);
        }
      }
    }
    for (int i = 0; i < 256; i++) {

      if (c == 1) {
        g.setColor(new Color(65, 175, 67, 200));
        g.fillRect(i, 256 - greenHeight[i], 1, greenHeight[i]);
      } else if (c == 2) {
        g.setColor(new Color(176, 50, 50, 200));
        g.fillRect(i, 256 - redHeight[i] , 1, redHeight[i]);
      } else if (c == 3) {
        g.setColor(new Color(54, 86, 141, 200));
        g.fillRect(i, 256 - blueHeight[i] , 1, blueHeight[i]);
      }
      else {
        g.setColor(new Color(89, 86, 86, 200));
        g.fillRect(i, 256 - avgHeight[i], 1, avgHeight[i]);
      }
    }

    g.setColor(new Color(100, 97, 97));
    g.drawRect(0, 0, 256, 256);

  }

  private void scaleBars(int[] bars) {
    int max = 0;
    for (int i : bars) {
      max = Math.max(i, max);
    }
    double scale = ((double) max) / 240;
    for (int i = 0; i < bars.length; i++) {
      if (bars[i] > maximumCount) {
        maximumCount = bars[i];
      }
      bars[i] = (int) (bars[i] / scale);
    }
  }

  public static void main(String[] args) {
    IImage image = ImageUtil.decodeImage("res/monalisa.jpg");
    Histogram h1 = new Histogram(image, 4);
    JFrame f = new JFrame();
    f.setSize(new Dimension(256, 256));
    f.add(h1);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }


}
