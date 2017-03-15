package org.callahan.necknotes.components.neck;

import javafx.scene.canvas.GraphicsContext;
import org.callahan.necknotes.components.notes.ToggleToneEvent;
import org.callahan.necknotes.components.utils.ResizableCanvas;
import org.callahan.necknotes.controllers.Controllers;


public class FretBoardCanvas extends ResizableCanvas {

  private FretBoardContext context;

  public FretBoardCanvas() {
    Controllers.get(NeckSpecificationsController.class)
      .addListener(this::updateSpecs);
    setSnapToPixel(false);
  }

  @Override
  protected void draw(GraphicsContext gc, double width, double height) {
    context.updateSize(width, height);
    new NeckDrawer(context, gc).draw();
  }

  private void updateSpecs(NeckSpecsChangedEvent evt) {
    context = evt.getUpdatedContext();
    redraw();
  }

  private void updateNotes(ToggleToneEvent evt) {
    redraw();
  }

}
