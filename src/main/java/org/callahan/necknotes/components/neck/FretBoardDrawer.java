package org.callahan.necknotes.components.neck;

import javafx.scene.canvas.GraphicsContext;

class FretBoardDrawer extends NeckPartDrawer {

  FretBoardDrawer(GraphicsContext g, FretBoardContext ctx) {
    super(ctx, g);
  }

  @Override
  public void draw() {
    new NeckDrawer(this).draw();
    //new NotesDrawer(this).draw();
    //new DebugDrawer(this).draw();
  }

}
