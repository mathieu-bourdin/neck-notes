package org.callahan.necknotes.components.neck;

import org.callahan.necknotes.components.utils.GfxDrawer;

import java.awt.*;

abstract class NeckPartDrawer extends GfxDrawer {

  FretBoardContext context;

  NeckPartDrawer(NeckPartDrawer np) {
    this(np.context, np.gfx);
  }

  NeckPartDrawer(FretBoardContext ctx, Graphics g) {
    super(g);
    context = ctx;
  }

}
