package org.callahan.necknotes.components.neck;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import org.callahan.necknotes.components.menu.MainMenu;
import org.callahan.necknotes.components.tuning.TuningButtons;


public class Neck extends GridPane {

  public Neck() {

    Button menu = new MainMenu();
    add(menu, 0, 0);

    Node fretsNumber = new FretsNumbering();
    add(fretsNumber, 1, 0);
    setHgrow(fretsNumber, Priority.ALWAYS);
    setFillWidth(fretsNumber, true);

    Node tuning = new TuningButtons();
    add(tuning, 0, 1);
    setVgrow(tuning, Priority.ALWAYS);
    setFillHeight(tuning, true);

    //FretBoardCanvas fbc = new FretBoardCanvas();
    //FrettedNotes f = new FrettedNotes();
    StackPane sp = new StackPane();
    sp.getChildren().addAll(new FretBoardCanvas(), new FrettedNotes());
    add(sp, 1, 1);

    //add(new FrettedNoteButton("F#"), 2, 2);
    //Button b = new Button("F#");
    //b.setShape(new Circle(12.0));
    //add(b, 2, 2);
  }

}
