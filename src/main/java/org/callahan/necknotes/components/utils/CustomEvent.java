package org.callahan.necknotes.components.utils;

import javafx.event.Event;
import javafx.event.EventType;

public abstract class CustomEvent extends Event {

  public CustomEvent() {
    super(EventType.ROOT);
  }
}
