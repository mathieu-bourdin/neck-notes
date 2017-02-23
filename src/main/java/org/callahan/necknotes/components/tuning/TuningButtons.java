package org.callahan.necknotes.components.tuning;

import org.callahan.necknotes.components.neck.FretBoardContext;
import org.callahan.necknotes.components.neck.NeckPartComponent;
import org.callahan.necknotes.core.InstrumentString;
import org.callahan.necknotes.core.Note;

import javax.swing.*;
import java.awt.*;
import java.util.List;


/**
 * A panel with tuning buttons (fits next to NeckView).
 */
public class TuningButtons extends NeckPartComponent {

  @Override
  public void neckPropertiesChanged(FretBoardContext ctx) {
    setupStrings(ctx.neckSpec.getStrings());
  }

  private void setupStrings(List<InstrumentString> strings) {

    removeAll();
    setLayout(createLayout(strings));

    strings.stream()
      .map(InstrumentString::getRootNote)
      .forEach(this::addButton);
  }

  private GridLayout createLayout(List<InstrumentString> strings) {
    GridLayout res = new GridLayout(strings.size(), 1);
    res.setVgap(4);
    return res;
  }

  private void addButton(Note note) {
    JButton b = new JButton(note.getTone().getLabel());
    b.setMargin(new Insets(0, 0, 0, 0));
    b.setFocusPainted(false);
    add(b);
  }


}
