package org.callahan.necknotes.components.neck;

public class DebugDrawer extends NeckPartDrawer {

  public DebugDrawer(NeckPartDrawer np) {
    super(np);
  }

  @Override
  public void draw() {
    setStrokeColor("#FF0000");
    drawRect(0, 0, 10, 10);
    setFillColor("FF8800");
    fillRect(2, 2, 6, 6);

    drawRect(10, 10, 7, 7);
    fillRect(11, 11, 5, 5);
    setStrokeColor("#0000FF");
    drawOval(10, 10, 7, 7);

    setStrokeColor("#00FF00");
    drawRect(20, 20, 20, 20);
    setStrokeColor("#FF0000");
    drawOval(20, 20, 20, 20);
    drawCircle(29.5, 29.5, 10);

    drawCircle(50.0, 40.0, 8);
    fillCircle(50.0, 40.0, 6);

    //drawCircle(100.0, 100.0, 50.0);
    setStrokeColor("#000000");
    drawRect(50, 50, 100, 100);
    setStrokeColor("#FF0000");
    drawLine(50, 50, 149, 149);
    setStrokeColor("#0000FF");
    drawLine(50, 149, 149, 50);
    setStrokeColor("#00FF00");
    double center = (50.0+149.0)/2.0;
    drawLine(center, 50, center, 149);
    drawLine(50, center, 149, center);
    setStrokeColor("#ff00ff");
    drawCircle(center, center, 50);


    double x = 200;
    double y = 100;
    setFillColor("#FF0000");
    drawStringCentered("M#", x, y);
    setStrokeColor("#00000080");
    drawLine(x, y - 20, x, y - 10);
    drawLine(x - 20, y, x - 10, y);
  }
}
