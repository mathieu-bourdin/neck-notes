package org.callahan.necknotes.components.utils;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public abstract class ResizableCanvas extends Pane {

  private final Canvas canvas;

  public ResizableCanvas() {
    canvas = new Canvas();
    getChildren().add(canvas);
  }

  protected abstract void draw(GraphicsContext gc, double width, double height);

  public final void redraw() {
    layoutChildren(true);
  }

  @Override
  protected void layoutChildren() {
    layoutChildren(false);
  }

  private void layoutChildren(boolean forceRedraw) {
    int top = (int)snappedTopInset();
    int right = (int)snappedRightInset();
    int bottom = (int)snappedBottomInset();
    int left = (int)snappedLeftInset();
    int w = (int)getWidth() - left - right;
    int h = (int)getHeight() - top - bottom;
    canvas.setLayoutX(left);
    canvas.setLayoutY(top);
    if (forceRedraw || w != canvas.getWidth() || h != canvas.getHeight()) {
      canvas.setWidth(w);
      canvas.setHeight(h);
      draw(canvas.getGraphicsContext2D(), w, h);
    }
  }

}
