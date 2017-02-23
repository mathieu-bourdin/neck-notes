package org.callahan.necknotes.components.neck;

import org.callahan.necknotes.components.utils.GfxDrawer;

import java.awt.*;

class FretsNumbering extends NeckPartComponent {

  private FretBoardContext context;

  public FretsNumbering() {
    setMinimumSize(new Dimension(100, 20));
    setMaximumSize(new Dimension(100, 20));
    setPreferredSize(new Dimension(100, 20));
  }

  @Override
  protected void paintComponent(Graphics g) {
    new Drawer(g, context).draw();
  }

  @Override
  public void neckPropertiesChanged(FretBoardContext ctx) {
    context = ctx;
  }

  private static class Drawer extends GfxDrawer {

    private final FretBoardContext context;

    public Drawer(Graphics g, FretBoardContext ctx) {
      super(g);
      context = ctx;
    }
    @Override
    public void draw() {
      setColor(FretBoardColors.FRET);
      double y = 12;
      for (int i = 1; i <= context.columns; ++i) {
        double x = context.fretCenterX(i);
        drawStringCentered(String.valueOf(i), x, y);
      }
    }

  }
}
