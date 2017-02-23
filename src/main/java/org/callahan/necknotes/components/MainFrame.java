package org.callahan.necknotes.components;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

//  private Neck neck;

  public MainFrame() {
    super("Neck notes 1.0");
    add(new MainPanel());
    setupWindow();
  }

  private void setupWindow() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(640, 240));
    setMinimumSize(new Dimension(600, 200));
    pack();
  }
}
