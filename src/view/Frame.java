package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.ImageAppBetterController;
import model.ImageAppModel;

public class Frame extends JFrame implements IView {

  JPanel centerContent;
  JPanel eastContent;

  JPanel southContent;
  JPanel westContent;


  JLabel image;

  JPanel hist1;
  JPanel hist2;
  JPanel hist3;

  JPanel hists[];

  Button load;

  JPanel avgPanel;

  Button[] buttons = new Button[]{};


  public Frame() {
    this.setSize(1000, 800);

    this.hists = new JPanel[]{hist1, hist2, hist3};
    this.westContent = new JPanel();
    this.westContent.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    westContent.setLayout(new BoxLayout(westContent, BoxLayout.Y_AXIS));
    this.hist1 = new JPanel();
    hist1.setPreferredSize(new Dimension(256, 256));
    this.hist2 = new JPanel();
    hist2.setPreferredSize(new Dimension(256, 256));
    this.hist3 = new JPanel();
    hist3.setPreferredSize(new Dimension(256, 256));
    westContent.add(hist1);
    westContent.add(hist2);
    westContent.add(hist3);

    //




    this.eastContent = new JPanel();
    this.eastContent.setLayout(new BoxLayout(eastContent, BoxLayout.Y_AXIS));

    JPanel buttons = new JPanel();
    buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));

    JPanel operationButtons = new JPanel();
    operationButtons.setBorder(BorderFactory.createLineBorder(Color.RED));
    operationButtons.setLayout(new BoxLayout(operationButtons, BoxLayout.X_AXIS));

    JPanel visualize = new JPanel();
    visualize.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    visualize.setLayout(new GridLayout(7, 1,10,10));

    JLabel visLabel = new JLabel("Visualize Component:", SwingConstants.CENTER);
    visLabel.setFont(new Font("Calibri",Font.PLAIN,12));
    //visLabel.setBorder(new EmptyBorder(15, 15, 15, 15));
    //visLabel.setPreferredSize(new Dimension(47, 98));
    Button red = new Button("Red");
    Button green = new Button("Green");
    Button blue = new Button("Blue");
    Button in = new Button("Intensity");
    Button lu = new Button("Luma");
    Button val = new Button("Value");

    JPanel operations = new JPanel();
    operations.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    operations.setLayout(new GridLayout(7, 1, 20, 20));

    Button brighten = new Button("Brighten");
    Button vflip = new Button("Vertical Flip");
    Button hflip = new Button("Horizontal Flip");
    Button sepia = new Button("Sepia Tone");
    Button gray = new Button("Grayscale");
    Button blur = new Button("Blur");
    Button sharp = new Button("Sharpen");

    operations.add(brighten);
    operations.add(vflip);
    operations.add(hflip);
    operations.add(sepia);
    operations.add(gray);
    operations.add(blur);
    operations.add(sharp);


    visualize.add(visLabel);
    visualize.add(red);
    visualize.add(green);
    visualize.add(blue);
    visualize.add(in);
    visualize.add(lu);
    visualize.add(val);

    operationButtons.add(visualize);
    operationButtons.add(operations);

    buttons.add(operationButtons);

    JPanel loadSave = new JPanel();
    loadSave.setLayout(new BoxLayout(loadSave, BoxLayout.X_AXIS));

    load = new Button("Load");
    Button save = new Button("Save");

    loadSave.add(load);
    loadSave.add(save);

    buttons.add(loadSave);


    avgPanel = new JPanel();
    avgPanel.setPreferredSize(new Dimension(256, 256));


    avgPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));

    this.eastContent.add(buttons);
    this.eastContent.add(avgPanel);

    eastContent.setBorder(BorderFactory.createLineBorder(Color.BLUE));


    //




    this.image = new JLabel();
    JScrollPane main = new JScrollPane(this.image);
    main.setPreferredSize(new Dimension(650, 800));

    //eastContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    eastContent.setPreferredSize(new Dimension(256, 800));

    // pack();

    this.requestFocus();
    this.add(this.eastContent, BorderLayout.EAST);
    this.add(main, BorderLayout.CENTER);
    this.add(this.westContent, BorderLayout.WEST);


    this.setMinimumSize(this.getSize());
    this.pack();
    this.setMinimumSize(null);


  }


  public void displayImage(BufferedImage image) {
    ImageIcon i = new ImageIcon(image);
    this.image.setIcon(i);
  }

  @Override
  public void addActionListener(ActionListener listener) {
    /**
     Enumeration<AbstractButton> en = this.loadedImagesBG.getElements();
     while(en.hasMoreElements()) {
     System.out.println("here!!!");
     AbstractButton b = en.nextElement();
     b.addActionListener(listener);
     }
     */
    for (Button b : this.buttons) {
      b.addActionListener(listener);
   }
    this.load.addActionListener(listener);

  }

  @Override
  public void setHist(Histogram[] hist) {
    this.westContent.removeAll();
    for (int i = 0; i < 3; i++) {
      this.westContent.add(hist[i]);
    }

    this.eastContent.remove(avgPanel);
    this.eastContent.add(hist[3]);
    avgPanel = hist[3];

    this.setMinimumSize(this.getSize());
    this.pack();
    this.setMinimumSize(null);

  }


  public static void main(String[] args) {
    ImageAppModel m = new ImageAppModel();
    ImageAppBetterController c = new ImageAppBetterController(m);
    Frame frame = new Frame();
    c.setView(frame);
    Frame.setDefaultLookAndFeelDecorated(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setResizable(false);
  }

  @Override
  public String getFileToLoad() {
    final JFileChooser fchooser = new JFileChooser(".");
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "PNG, JPG, BMP, and PPM files are supported.", "jpg", "png", "bmp", "ppm");
    fchooser.setFileFilter(filter);
    int retvalue = fchooser.showOpenDialog(Frame.this);
    if (retvalue == JFileChooser.APPROVE_OPTION) {
      File f = fchooser.getSelectedFile();
      return f.getAbsolutePath();
    } else {
      JOptionPane.showMessageDialog(this, "File type is not supported.");
    }
    return null;
  }

  @Override
  public String getSaveDest() {
    return null;
  }


}
