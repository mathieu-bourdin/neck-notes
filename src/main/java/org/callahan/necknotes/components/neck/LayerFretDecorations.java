package org.callahan.necknotes.components.neck;

import javafx.scene.canvas.GraphicsContext;
import org.callahan.necknotes.components.utils.ResizableCanvas;
import org.callahan.necknotes.controllers.Controllers;

public class LayerFretDecorations extends ResizableCanvas {

  private FretBoardContext context;

  public LayerFretDecorations() {
    Controllers.get(NeckSpecificationsController.class)
      .addListener(this::updateContext);
    //FretBoardDrawer drawer = new FretBoardDrawer()
  }

  private void updateContext(NeckSpecsChangedEvent evt) {
    context = evt.getUpdatedContext();
    redraw();
  }

  @Override
  protected void draw(GraphicsContext gc, double width, double height) {

    new FretBoardDrawer(gc, context).draw();

//    Font f2 = new Font(gc.getFont().getName(), height / 2);
//    gc.setFont(f2);
//    gc.clearRect(0, 0, width, height);
//    gc.fillText(context.neckSpec.getName(), 0.5, height * 0.6666);
    //gc.fillText("B\u266D", 0.5, height * 0.6666);
  }

//  private void drawDots(GraphicsContext gc, FretDecoration deco) {
//    if (deco.getFretIndex() > context.columns) {
//      return;
//    }
//    double x = context.fretCenterX(deco.getFretIndex());
//    int count = deco.getDecorationId();
//    for (int i = 1; i <= count; ++i) {
//      gc.fillCircle(
//        x,
//        i * context.height / (count + 1),
//        context.cellMinEdge * FretBoardMetrics.DECO_DOT_CELL_RATIO
//      );
//    }
//  }

}
