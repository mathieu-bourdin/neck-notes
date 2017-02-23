package org.callahan.necknotes.components;

import org.callahan.necknotes.components.neck.Neck;
import org.callahan.necknotes.components.notes.TonesButtons;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

  public MainPanel() {
    setLayout(new BorderLayout());
    add(new Neck(), BorderLayout.CENTER);
    add(new TonesButtons(), BorderLayout.SOUTH);
  }
}
