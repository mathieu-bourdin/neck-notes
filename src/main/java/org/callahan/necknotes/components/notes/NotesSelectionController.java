package org.callahan.necknotes.components.notes;

import org.callahan.necknotes.controllers.Controller;
import org.callahan.necknotes.core.NeckNotesFacade;
import org.callahan.necknotes.core.Tone;

public class NotesSelectionController extends Controller<ToggleToneEvent> {

  public void toggleTone(Tone tone) {
    boolean wasSelected = NeckNotesFacade.isSelected(tone);
    if (wasSelected) {
      NeckNotesFacade.deselectTone(tone);
    } else {
      NeckNotesFacade.selectTone(tone);
    }
    if (wasSelected != NeckNotesFacade.isSelected(tone)) {
      notifyListeners(new ToggleToneEvent(tone));
    }
  }
}
