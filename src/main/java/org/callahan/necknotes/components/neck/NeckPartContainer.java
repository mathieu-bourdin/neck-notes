package org.callahan.necknotes.components.neck;

import java.awt.*;
import java.util.Arrays;

public class NeckPartContainer extends NeckPartComponent {

  protected NeckPartContainer() {
    super();
  }

  protected NeckPartContainer(LayoutManager layout) {
    super(layout);
  }

  @Override
  public final void neckPropertiesChanged(FretBoardContext ctx) {
    Arrays.stream(getComponents())
      .filter(c -> c instanceof NeckPartComponent)
      .map(c -> (NeckPartComponent) c)
      .forEach(c -> c.neckPropertiesChanged(ctx));
    repaint();
  }
}
