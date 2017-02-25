package org.callahan.necknotes.components.neck;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Screen;


public class Neck extends GridPane {

  public Neck() {

    Node fretsNumber = createFretsNumbers();
    add(fretsNumber, 1, 0);
    setHgrow(fretsNumber, Priority.ALWAYS);
    setFillWidth(fretsNumber, true);

    Button tuning = createTuningButtons();
    add(tuning, 0, 1);
    setVgrow(tuning, Priority.ALWAYS);
    setFillHeight(tuning, true);

    Node fretBoard = createFretBoard();
    add(fretBoard, 1, 1);

  }

  private Button createTuningButtons() {
    Button r = new Button("I");
    r.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    return r;
  }

  private Node createFretsNumbers() {
    Button r = new Button("1 2 3 4 5 6 7 8 9 10 11 12");
    r.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    return r;
  }

  private Node createFretBoard() {
    Button r = new Button("FRETBOARD");
    r.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    return r;
  }

}
