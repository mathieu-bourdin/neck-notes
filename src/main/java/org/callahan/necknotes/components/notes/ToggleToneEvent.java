package org.callahan.necknotes.components.notes;

import org.callahan.necknotes.components.utils.CustomEvent;
import org.callahan.necknotes.core.Tone;

public class ToggleToneEvent extends CustomEvent {

  private final Tone tone;

  public ToggleToneEvent(Tone t) {
    tone = t;
  }

  public Tone getTone() {
    return tone;
  }
}
