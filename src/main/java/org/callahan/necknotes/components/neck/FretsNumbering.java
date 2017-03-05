package org.callahan.necknotes.components.neck;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import org.callahan.necknotes.components.FretBoardColors;
import org.callahan.necknotes.controllers.Controllers;


class FretsNumbering extends HBox {

  private FretBoardContext context;

  public FretsNumbering() {
    Controllers.get(NeckSpecificationsController.class)
      .<NeckSpecsChangedEvent>addListener(e -> setup(e.getUpdatedContext()));
  }

  private void setup(FretBoardContext ctx) {
    context = ctx;
    update();
  }

  private void update() {
    getChildren().clear();
    for (int i = 1; i <= context.columns; ++i) {

      Label l = new Label("" + i);
      l.setBorder(Border.EMPTY);
      l.setPadding(Insets.EMPTY);
      HBox.setHgrow(l, Priority.ALWAYS);
      l.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
      l.setPrefWidth(32);
      l.setFocusTraversable(false);
      l.setAlignment(Pos.CENTER);
      l.setTextFill(FretBoardColors.DEFAULT.getFrettedNoteForeground());
      getChildren().add(l);
    }
  }

}
