package org.callahan.necknotes.components.neck;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.callahan.necknotes.components.utils.ResizableCanvas;

public class DebugCanvas extends ResizableCanvas {

  @Override
  protected void draw(GraphicsContext gc, double width, double height) {
    gc.clearRect(0, 0, width, height);
    gc.setStroke(Color.RED);
    gc.strokeRect(0.5, 0.5, width - 1, height - 1);
    gc.setStroke(Color.BLACK);
    gc.strokeLine(0.5, 0.5, width - 0.5, height - 0.5);
    gc.strokeLine(0.5, height - 0.5, width - 0.5, 0.5);
  }
}
