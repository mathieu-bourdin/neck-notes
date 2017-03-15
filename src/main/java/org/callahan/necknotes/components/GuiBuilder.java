package org.callahan.necknotes.components;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.callahan.necknotes.components.neck.Neck;
import org.callahan.necknotes.components.notes.ToneSelector;

public class GuiBuilder {

  public Parent build() {
    VBox pane = new VBox();
    Node neck = neckDisplay();
    Node tones = tonesSelector();
    pane.getChildren().addAll(neck, tones);
    VBox.setVgrow(neck, Priority.ALWAYS);
    VBox.setVgrow(tones, Priority.NEVER);
    return pane;
  }

  private Node tonesSelector() {
    return new ToneSelector();
  }

  private Node neckDisplay() {
    return new Neck();
  }
}
