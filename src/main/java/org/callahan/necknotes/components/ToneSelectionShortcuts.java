package org.callahan.necknotes.components;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.callahan.necknotes.components.notes.NotesSelectionController;
import org.callahan.necknotes.components.utils.Controllers;
import org.callahan.necknotes.core.Tone;

import java.util.Optional;

public class ToneSelectionShortcuts {


  public static EventHandler<? super KeyEvent> createHandler() {
    return ke -> toneForKeyEvent(ke)
      .ifPresent(Controllers.get(NotesSelectionController.class)::toggleTone);
  }

  private static Optional<Tone> toneForKeyEvent(KeyEvent evt) {
    System.out.println("KeyEvent = " + evt);
    int toneOrder;
    if (evt.getCode() == KeyCode.C) {
      toneOrder = 0;
    } else if (evt.getCode() == KeyCode.D) {
      toneOrder = 2;
    } else if (evt.getCode() == KeyCode.E) {
      toneOrder = 4;
    } else if (evt.getCode() == KeyCode.F) {
      toneOrder = 5;
    } else if (evt.getCode() == KeyCode.G) {
      toneOrder = 7;
    } else if (evt.getCode() == KeyCode.A) {
      toneOrder = 9;
    } else if (evt.getCode() == KeyCode.B) {
      toneOrder = 11;
    } else {
      return Optional.empty();
    }
    if (evt.isShiftDown()) {
      toneOrder++;
    }
    return Optional.of(Tone.fromOrder(toneOrder % 12));

  }

}
