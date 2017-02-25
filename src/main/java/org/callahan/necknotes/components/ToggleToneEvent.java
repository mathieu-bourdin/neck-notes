package org.callahan.necknotes.components;

import javafx.event.Event;
import javafx.event.EventType;
import org.callahan.necknotes.core.Tone;

public class ToggleToneEvent extends Event {

  private final Tone tone;

  public ToggleToneEvent(Tone t) {
    super(EventType.ROOT);
    tone = t;
  }

  public Tone getTone() {
    return tone;
  }
}
