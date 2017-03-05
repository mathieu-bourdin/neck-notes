package org.callahan.necknotes.components.utils;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BorderFactory {

  public static Border create(Color c, double thickness) {
    return new Border(
      new BorderStroke(
        c,
        BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY,
        new BorderWidths(thickness)
      )
    );
  }
}
