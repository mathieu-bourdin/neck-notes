package org.callahan.necknotes.components;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import org.callahan.necknotes.components.neck.Neck;
import org.callahan.necknotes.components.notes.ToneSelector;

public class GuiBuilder {

  public Parent build() {
    BorderPane pane = new BorderPane();
    pane.setCenter(neckDisplay());
    pane.setBottom(tonesSelector());
    pane.addEventHandler(
      KeyEvent.KEY_PRESSED,
      ToneSelectionShortcuts.createHandler()
    );
    return pane;
  }

  private Node tonesSelector() {
    return new ToneSelector();
  }

  private Node neckDisplay() {
    return new Neck();//Button("Here goes the neck");
  }
}
