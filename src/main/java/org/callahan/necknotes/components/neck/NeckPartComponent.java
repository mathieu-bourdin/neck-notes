package org.callahan.necknotes.components.neck;

import javax.swing.*;
import java.awt.*;

public abstract class NeckPartComponent extends JPanel {

  public NeckPartComponent() {
  }

  protected NeckPartComponent(LayoutManager layout) {
    super(layout);
  }

  public abstract void neckPropertiesChanged(FretBoardContext ctx);

}
