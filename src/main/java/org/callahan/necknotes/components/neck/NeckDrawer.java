package org.callahan.necknotes.components.neck;

import javafx.scene.canvas.GraphicsContext;
import org.callahan.necknotes.components.FretBoardColors;
import org.callahan.necknotes.core.FretDecoration;
import org.callahan.necknotes.core.InstrumentString;

class NeckDrawer extends NeckPartDrawer {

  NeckDrawer(FretBoardContext ctx, GraphicsContext gc) {
    super(ctx, gc);
  }

  @Override
  public void draw() {

    drawBackground();

    drawDecorations();

    drawFrets();

    drawStrings();
  }

  private void drawBackground() {
    setFillColor(FretBoardColors.DEFAULT.getNeck());
    fillRect(0, 0, context.width, context.height);
  }

  private void drawDecorations() {
    setFillColor(FretBoardColors.DEFAULT.getDots());
    context.neckSpec.getFretDecorations().forEach(this::drawDots);
  }

  private void drawStrings() {
    context.neckSpec.getStrings().forEach(this::drawString);
  }

  private void drawFrets() {
    setFillColor(FretBoardColors.DEFAULT.getFret());
    // First fret:
    fillRect(0, 0, context.fretWidth, context.height);
    // Intermediate frets:
    for (int i = 1; i < context.columns; ++i) {
      double x = context.cellW * i - context.fretWidth * 0.5;
      fillRect(x, 0, context.fretWidth, context.height);
    }
    // Last fret:
    fillRect(context.width - context.fretWidth, 0, context.fretWidth, context.height);
  }

  private void drawString(InstrumentString str) {
    setFillColor(FretBoardColors.DEFAULT.getString());
    double stringWidth = context.gaugeToPixels(str.getGauge());
    double y = context.cellH * (str.getIndex() + 0.5) - stringWidth * 0.5;
    double startX = (str.getFirstFret() - 1) * context.cellW - context.fretWidth / 2;
    fillRect(startX, y, context.width + context.fretWidth, stringWidth);
  }

  private void drawDots(FretDecoration deco) {
    if (deco.getFretIndex() > context.columns) {
      return;
    }
    double x = context.fretCenterX(deco.getFretIndex());
    int count = deco.getDecorationId();
    for (int i = 1; i <= count; ++i) {
      fillCircle(
        x,
        i * context.height / (count + 1),
        context.cellMinEdge * FretBoardMetrics.DECO_DOT_CELL_RATIO
      );
    }
  }

}
