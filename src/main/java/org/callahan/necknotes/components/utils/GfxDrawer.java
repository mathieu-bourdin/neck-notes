package org.callahan.necknotes.components.utils;

import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public abstract class GfxDrawer {

  protected final GraphicsContext gc;

  public GfxDrawer(GraphicsContext g) {
    gc = g;
  }

  public abstract void draw();

  public void drawLine(double x, double y, double xx, double yy) {
    gc.strokeLine(x + 0.5, y + 0.5, xx + 0.5, yy + 0.5);
  }

  public void fillOval(double x, double y, double w, double h) {
    gc.fillOval(x, y, w, h);
  }

  public void drawOval(double x, double y, double w, double h) {
    gc.strokeOval(x + 0.5, y + 0.5, w - 1.0, h - 1.0);
  }

  public void fillCircle(double x, double y, double radius) {
    gc.fillOval(x - radius + 1, y - radius + 1, radius * 2.0 - 1, radius * 2.0 - 1);
  }

  public void drawCircle(double x, double y, double radius) {
    gc.strokeOval(x - radius + 1, y - radius + 1, 2.0 * radius - 1, 2 * radius - 1);
  }

  public void drawString(String str, double x, double y) {
    gc.fillText(str, x + 0.5, y + 0.5);
  }

  public void drawStringCentered(String str, double x, double y) {
    Bounds bounds = computeBounds(str, gc.getFont());
    drawString(
      str,
      x - bounds.getWidth() / 2.0d - 1,
      y + bounds.getHeight() / 2.0d
    );
  }

  public Bounds computeBounds(String s, Font f) {
    Text text = new Text(s);
    text.setFont(f);
    Bounds tb = text.getBoundsInLocal();
    Rectangle stencil = new Rectangle(
      tb.getMinX(), tb.getMinY(), tb.getWidth(), tb.getHeight()
    );
    Shape intersection = Shape.intersect(text, stencil);
    Bounds ib = intersection.getBoundsInLocal();
    return ib;
  }

  public void setStrokeColor(Color c) {
    gc.setStroke(c);
  }

  public void setStrokeColor(String color) {
    gc.setStroke(Color.valueOf(color));
  }

  public void setFillColor(Color c) {
    gc.setFill(c);
  }

  public void setFillColor(String color) {
    gc.setFill(Color.valueOf(color));
  }

  public void drawRect(double x, double y, double w, double h) {
    gc.strokeRect(x + 0.5, y + 0.5, w - 1.0, h - 1.0);
  }

  public void fillRect(double x, double y, double w, double h) {
    gc.fillRect(x, y, w, h);
  }

}
