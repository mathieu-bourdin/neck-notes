package org.callahan.necknotes.components.notes;

import org.callahan.necknotes.Main;
import org.callahan.necknotes.core.Tone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

/**
 * Selects tones with on/off buttons.
 */
public class TonesButtons extends JPanel {

  public TonesButtons() {
    reorder();
  }

  private void reorder() {
    removeAll();
    setLayout(new GridLayout(1, Main.FACADE.getTonesOrder().size()));
    Main.FACADE.getTonesOrder().forEach(this::addToneButton);
  }

  private void addToneButton(Tone tone) {

    ToggleToneAction action = new ToggleToneAction(tone);

    JToggleButton b = new JToggleButton(action);
    // Declare action in action map...
    b.getActionMap().put(action.getCommand(), quickAction(e -> {
      action.actionPerformed(e);
      b.setSelected(!b.isSelected());
    }));
    // ... and trigger action when key is pressed:
    b.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
      .put(action.getKeyStroke(), action.getCommand());

    b.setSelected(Main.FACADE.isSelected(tone));
    b.setMargin(new Insets(0, 0, 0, 0));
    b.setFocusPainted(false);
    add(b);
  }

  private Action quickAction(Consumer<ActionEvent> evt) {
    return new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        evt.accept(e);
      }
    };
  }
}
