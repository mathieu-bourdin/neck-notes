package org.callahan.necknotes.components.utils;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;

import java.util.HashSet;
import java.util.Set;

public abstract class Controller {

  private Set<EventHandler> listeners = new HashSet<>();

  public final void notifyListeners(Event e) {
    listeners.forEach(h -> h.handle(e));
  }

  public final <T extends Event> void addListener(EventHandler<T> h) {
    listeners.add(h);
  }

}
