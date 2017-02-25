package org.callahan.necknotes.components.notes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import org.callahan.necknotes.components.ToggleToneEvent;
import org.callahan.necknotes.components.utils.Controllers;
import org.callahan.necknotes.core.NeckNotesFacade;
import org.callahan.necknotes.core.Tone;

public class ToneSelector extends HBox {

  public ToneSelector() {
    NeckNotesFacade.getTonesOrder().forEach(this::addToneButton);
  }

  private void addToneButton(Tone tone) {
    getChildren().add(createToneButton(tone));
  }
  private ToggleButton createToneButton(Tone tone) {
    ToggleButton button = new ToggleButton(tone.getLabel());
    button.setOnAction(buttonPressed(button, tone));
    setupListener(button, tone);

    HBox.setHgrow(button, Priority.ALWAYS);
    button.setMaxWidth(Double.MAX_VALUE);
    button.setPrefWidth(24.0);
    button.setMinWidth(24.0);
    //setAlignment(Pos.BOTTOM_CENTER);//PrefWidth(Double.MAX_VALUE);
    //setScaleShape(true);
    button.setFocusTraversable(false);
    return button;
  }

  private void setupListener(ToggleButton button, Tone tone) {
    Controllers.get(NotesSelectionController.class)
      .<ToggleToneEvent>addListener(e -> {
        if (e.getTone() == tone) {
          System.out.printf("Handling controller toggled tone: %s\n", tone);
          button.setSelected(NeckNotesFacade.isSelected(tone));
        }
      });
  }

  private EventHandler<ActionEvent> buttonPressed(ToggleButton tb, Tone t) {
    return evt -> {
      Controllers.get(NotesSelectionController.class).toggleTone(t);
      System.out.printf("Button pressed %s for tone %s\n", tb, t);
    };
  }

}
