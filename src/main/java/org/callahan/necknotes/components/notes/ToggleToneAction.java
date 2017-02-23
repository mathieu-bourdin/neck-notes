package org.callahan.necknotes.components.notes;

import org.callahan.necknotes.components.utils.Controllers;
import org.callahan.necknotes.core.Tone;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

class ToggleToneAction extends AbstractAction {

  private final Tone tone;

  ToggleToneAction(Tone t) {
    super();
    tone = t;
    putValue(ACTION_COMMAND_KEY, getCommand());
    putValue(NAME, t.getLabel());
  }

  String getCommand() {
    return "toggle_" + tone.getLabel();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println("Toggle tone: " + tone);
    Controllers.get(NotesSelectionController.class)
      .toggleTone(tone);
  }

  KeyStroke getKeyStroke() {
    String label = tone.getLabel();
    return KeyStroke.getKeyStroke(
      label.charAt(0),
      label.length() > 1 ? InputEvent.SHIFT_DOWN_MASK : 0
    );
  }

}
