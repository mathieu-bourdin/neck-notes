package org.callahan.necknotes.components.neck;

class CellDrawer extends NeckPartDrawer {

  private FretCell cell;

  CellDrawer(NeckPartDrawer np) {
    super(np);
  }

  CellDrawer use(FretCell c) {
    cell = c;
    return this;
  }

  @Override
  public void draw() {
//    System.out.printf("%f, %f\n", cell.x, cell.y);
//    drawRect(cell.x , cell.y, context.cellW - 1, context.cellH - 1);
//    drawRect(cell.column * 10, cell.row * 10, 2, 2);
  }
}
