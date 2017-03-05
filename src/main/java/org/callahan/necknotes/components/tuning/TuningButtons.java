package org.callahan.necknotes.components.tuning;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.callahan.necknotes.components.neck.NeckSpecificationsController;
import org.callahan.necknotes.components.neck.NeckSpecsChangedEvent;
import org.callahan.necknotes.controllers.Controllers;
import org.callahan.necknotes.core.InstrumentString;
import org.callahan.necknotes.core.NeckNotesFacade;
import org.callahan.necknotes.core.NeckSpecifications;
import org.callahan.necknotes.core.Note;


public class TuningButtons extends VBox {

  public TuningButtons() {
    setup(NeckNotesFacade.getNeckSpecifications());
    Controllers.get(NeckSpecificationsController.class)
      .<NeckSpecsChangedEvent>addListener(e -> setup(e.getSpecifications()));
  }

  private void setup(NeckSpecifications specs) {
    getChildren().clear();
    specs.getStrings().stream()
      .map(InstrumentString::getRootNote)
      .forEach(this::addTuningButton);
  }

  private void addTuningButton(Note note) {
    Button button = new Button(note.getTone().getLabel());
    VBox.setVgrow(button, Priority.ALWAYS);
    button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    button.setMinHeight(0);
    button.setMinWidth(24);
    button.setPadding(new Insets(0, 4, 0, 4));
    button.setFocusTraversable(false);

    getChildren().add(button);
  }

}
