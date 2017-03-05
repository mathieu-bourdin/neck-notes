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
//    Controllers.get(NotesSelectionController.class)
//      .addListener(this::updateNotes);
  }

  @Override
  protected void draw(GraphicsContext gc, double width, double height) {
    context.updateSize(width, height);
//    debugDraw(gc, width, height);
    new FretBoardDrawer(gc, context).draw();
  }

//  private void debugDraw(GraphicsContext gc, double w, double h) {
//    double width = w;//context.width;
//    double height = h;//context.height;
//    gc.clearRect(0, 0, width, height);
//    gc.setStroke(Color.RED);
//    gc.strokeRect(0.5, 0.5, width - 1, height - 1);
//    gc.setStroke(Color.BLACK);
//    gc.strokeLine(0.5, 0.5, width - 0.5, height - 0.5);
//    gc.strokeLine(0.5, height - 0.5, width - 0.5, 0.5);
//
//  }

  private void updateSpecs(NeckSpecsChangedEvent evt) {
    context = evt.getUpdatedContext();
    redraw();
  }

  private void updateNotes(ToggleToneEvent evt) {
    redraw();
  }

}
