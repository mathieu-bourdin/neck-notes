package org.callahan.necknotes.controllers;

import javafx.event.Event;
import javafx.event.EventHandler;

import java.util.HashSet;
import java.util.Set;

public abstract class Controller<T extends Event> {

  private Set<EventHandler> listeners = new HashSet<>();

  public final void notifyListeners(T e) {
    listeners.forEach(h -> h.handle(e));
  }

  public final void addListener(EventHandler<T> h) {
    listeners.add(h);
  }

}
