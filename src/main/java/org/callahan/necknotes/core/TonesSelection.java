package org.callahan.necknotes.core;

import java.util.*;

public class TonesSelection {

  private final Set<Tone> selection;

  public TonesSelection() {
    selection = new HashSet<>(Tone.values().length);
  }

  public void selectTone(Tone t) {
    selection.add(t);
  }

  public boolean isSelected(Tone t) {
    return selection.contains(t);
  }

  public void deselectTone(Tone t) {
    selection.remove(t);
  }

  public Set<Tone> getSelectedTones() {
    return selection;
  }
}
