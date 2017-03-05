package org.callahan.necknotes.components.neck;

import javafx.scene.canvas.GraphicsContext;
import org.callahan.necknotes.components.utils.GfxDrawer;

abstract class NeckPartDrawer extends GfxDrawer {

  FretBoardContext context;

  NeckPartDrawer(NeckPartDrawer np) {
    this(np.context, np.gc);
  }

  NeckPartDrawer(FretBoardContext ctx, GraphicsContext gc) {
    super(gc);
    context = ctx;
  }

}
