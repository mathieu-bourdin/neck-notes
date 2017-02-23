package org.callahan.necknotes.components.notes;

import org.callahan.necknotes.Main;
import org.callahan.necknotes.components.utils.Controller;
import org.callahan.necknotes.core.Tone;

public class NotesSelectionController extends Controller {

  void toggleTone(Tone tone) {
    boolean wasSelected = Main.FACADE.isSelected(tone);
    if (wasSelected) {
      Main.FACADE.deselectTone(tone);
    } else {
      Main.FACADE.selectTone(tone);
    }
    if (wasSelected != Main.FACADE.isSelected(tone)) {
      notifyListeners();
    }
  }
}
