package org.callahan.necknotes.components.neck;

import org.callahan.necknotes.core.FretDecoration;
import org.callahan.necknotes.core.InstrumentString;

import static org.callahan.necknotes.components.neck.FretBoardMetrics.FRET_WIDTH_CELL_RATIO;

class NeckDrawer extends NeckPartDrawer {

  NeckDrawer(NeckPartDrawer np) {
    super(np);
  }

  @Override
  public void draw() {

    setColor(FretBoardColors.NECK);
    drawBackground();

    setColor(FretBoardColors.DOTS);
    drawDecorations();

    setColor(FretBoardColors.STRING);
    drawStrings();
  }

  private void drawBackground() {
    fillRect(0, 0, context.width, context.height);
  }

  private void drawDecorations() {
    context.neckSpec.getFretDecorations().forEach(this::drawDots);
  }

  private void drawStrings() {
    context.neckSpec.getStrings().forEach(this::drawString);
  }

  private void drawString(InstrumentString str) {

    int idx = str.getIndex();

    setColor(FretBoardColors.FRET);
    double y = context.cellH * idx;
    double fretWidth = Math.max(1.0, context.cellW * FRET_WIDTH_CELL_RATIO);
    double fretHeight = context.cellH + 1;
    // First fret:
    if (str.getFirstFret() == 1) {
      fillRect(0, y, fretWidth, fretHeight);
    } else {
      fillRect(context.cellW * (str.getFirstFret() - 1) - fretWidth * 0.5, y, fretWidth, fretHeight);
    }
    for (int i = str.getFirstFret(); i < str.getLastFret(); ++i) {
      double x = context.cellW * i - fretWidth * 0.5;
      fillRect(x, y, fretWidth, fretHeight);
    }
    if (str.getLastFret() == context.columns) {
      fillRect(context.width - fretWidth + 1, 0, fretWidth, context.height);
    } else {
      fillRect(context.cellW * str.getLastFret() - fretWidth * 0.5, 0, fretWidth, context.height);
    }
    // Last fret:

    setColor(FretBoardColors.STRING);
    double stringWidth = context.gaugeToPixels(str.getGauge());
    y = context.cellH * (idx + 0.5) - stringWidth * 0.5;
    double startX = (str.getFirstFret() - 1) * context.cellW;
    fillRect(startX, y, context.width, stringWidth);


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
