package org.callahan.necknotes.components.utils;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class Controller {

  private PropertyChangeSupport propSupport = new PropertyChangeSupport(this);

  public final void notifyListeners() {
    propSupport.firePropertyChange(
      new PropertyChangeEvent(this, null, null, null)
    );
  }

  public final void addListener(PropertyChangeListener l) {
    propSupport.addPropertyChangeListener(l);
  }

}
