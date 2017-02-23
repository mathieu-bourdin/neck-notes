package org.callahan.necknotes.components.utils;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_OFF;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

public abstract class GfxDrawer {

  protected final Graphics gfx;

  public GfxDrawer(Graphics g) {
    gfx = g;
    setAntialias();
  }

  private void setAntialias() {
    if (gfx instanceof Graphics2D) {
      ((Graphics2D) gfx)
        .setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
    }
  }

  public abstract void draw();

  public void drawLine(double x, double y, double xx, double yy) {
    gfx.drawLine(asInt(x), asInt(y), asInt(xx), asInt(yy));
  }

  public void fillOval(double x, double y, double w, double h) {
    gfx.fillOval(asInt(x), asInt(y), asInt(w) - 1, asInt(h) - 1);
  }

  public void drawOval(double x, double y, double w, double h) {
    gfx.drawOval(asInt(x), asInt(y), asInt(w) - 1, asInt(h) - 1);
  }

  public void fillCircle(double x, double y, double radius) {
    fillOval(x - radius + 1, y - radius, radius * 2.0, radius * 2.0);
  }

  public void drawCircle(double x, double y, double radius) {
    drawOval(x - radius + 1, y - radius, radius * 2.0, radius * 2.0);
  }

  public void drawString(String str, double x, double y) {
    gfx.drawString(str, asInt(x), asInt(y));
  }

  public void drawStringCentered(String str, double x, double y) {
    Rectangle2D bounds = gfx.getFontMetrics().getStringBounds(str, gfx);
    int strW = gfx.getFontMetrics().stringWidth(str);
    int descent = gfx.getFontMetrics().getDescent();
    drawString(
      str,
      x - strW / 2.0d,
      y + (bounds.getHeight() - descent) / 2.0d - 1
    );
  }

  public void drawDot(double x, double y) {
    gfx.drawLine(asInt(x), asInt(y), asInt(x), asInt(y));
  }

  public void setColor(String colorCode) {
    gfx.setColor(Color.decode(colorCode));
  }

  public void drawRect(double x, double y, double w, double h) {
    gfx.drawRect(asInt(x), asInt(y), asInt(w), asInt(h));
  }

  public void fillRect(double x, double y, double w, double h) {
    gfx.fillRect(asInt(x), asInt(y), asInt(w), asInt(h));
  }

  private int asInt(double d) {
    return (int) Math.round(d);
  }

}
