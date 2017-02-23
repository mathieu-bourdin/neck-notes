package org.callahan.necknotes.components.neck;

import org.callahan.necknotes.core.Tone;

import java.awt.*;

class FretBoardDrawer extends NeckPartDrawer {

  private FretBoardContext context;

  FretBoardDrawer(Graphics g, FretBoardContext ctx) {
    super(ctx, g);
    context = ctx;
  }

  @Override
  public void draw() {
    drawDebugBackground();
    new NeckDrawer(this).draw();
    new NotesDrawer(this).draw();
//    drawSelectedTones();
  }

  private void drawDebugBackground() {
    setColor("#FF0000");
    drawRect(0, 0, context.width - 1, context.height - 1);
    drawLine(0, 0, context.width - 1, context.height - 1);
    drawLine(0, context.height - 1, context.width - 1, 0);
  }

//
//  private double fretCenterX(int i) {
//    return cellW * i + cellW / 2.0;
//  }
//  private double fretCenterY(int i) {
//    return height - cellH * i - cellH / 2.0;
//  }
//
//
//  private void drawZeroFret() {
//    for (int i = 0; i < instrument.getStringsCount(); ++i) {
//      drawTone(
//        instrument.getStringRoot(i).getTone(),
//        (cellW / 2.0f),
//        height - cellH * i - cellH / 2.0f
//      );
//    }
//    //fillRect(cellW - cellW / 8.0, 0.0, cellW + cellW / 8.0, height);
//  }
//
//  private void drawTone(Tone t, double x, double y) {
//    drawStringCentered(t.getLabel(), x, y);
//  }

}
