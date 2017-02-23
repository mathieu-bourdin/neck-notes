package org.callahan.necknotes;

import org.callahan.necknotes.components.MainFrame;
import org.callahan.necknotes.core.necks.FiveStringsBass;
import org.callahan.necknotes.core.necks.GuitarStandard;
import org.callahan.necknotes.core.NeckNotesFacade;

import javax.swing.*;

public class Main implements Runnable {

  public static NeckNotesFacade FACADE =
    new NeckNotesFacade(new GuitarStandard());

  public static void main(String[] args) {
    try {

      // By default, we don't need much rendering optimization
      // and Direct3D rendering can be *slower* with bad drivers:
      setIfUndefined("sun.java2d.d3d", "false");
      // Same applies to X:
      setIfUndefined("sun.java2d.xrender", "false");

      setIfUndefined("awt.useSystemAAFontSettings","on");
      setIfUndefined("swing.aatext", "true");

      setupLookAndFeel();

      SwingUtilities.invokeLater(new Main());

    } catch (Throwable th) {
      th.printStackTrace(System.err);
    }
  }

  public void run() {
    new MainFrame().setVisible(true);
  }



  private static void setIfUndefined(final String name, final String value) {
    if (System.getProperty(name) == null) {
      System.setProperty(name, value);
    }
  }

  private static void setupLookAndFeel()
    throws ClassNotFoundException, InstantiationException,
    IllegalAccessException,
    UnsupportedLookAndFeelException {

//    for(UIManager.LookAndFeelInfo li : UIManager.getInstalledLookAndFeels()) {
//      System.out.println(li.getName() + ": " + li.getClassName());
//    }

    String lf = UIManager.getSystemLookAndFeelClassName();
    //lf = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
    lf = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
    System.out.println(lf);
    UIManager.setLookAndFeel(lf);

    // UIManager.getLookAndFeelDefaults().

  }
}
