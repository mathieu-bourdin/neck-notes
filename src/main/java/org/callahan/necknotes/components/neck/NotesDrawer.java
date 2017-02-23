package org.callahan.necknotes.components.neck;

import org.callahan.necknotes.Main;
import org.callahan.necknotes.core.InstrumentString;
import org.callahan.necknotes.core.Note;
import org.callahan.necknotes.core.Tone;

import java.util.Set;

public class NotesDrawer extends NeckPartDrawer {

  private final Set<Tone> selectedTones;

  public NotesDrawer(NeckPartDrawer np) {
    super(np);
    selectedTones = Main.FACADE.getSelectedTones();
  }

  @Override
  public void draw() {
    context.neckSpec.getStrings().forEach(this::drawTones);
  }

  private void drawTones(InstrumentString string) {
    string.streamNotes()
      .filter(n -> selectedTones.contains(n.getTone()))
      .forEach(n -> drawTone(n, string));
  }

  private void drawTone(Note note, InstrumentString string) {
    double x = context.fretCenterX(note.substract(string.getRootNote()));
    double y = context.fretCenterY(string.getIndex());
    setColor("#ffffff");
    fillCircle(x, y, context.cellMinEdge * 0.4);
    setColor("#000000");
    drawCircle(x, y, context.cellMinEdge * 0.4);
    drawStringCentered(note.getTone().getLabel(), x, y);
  }
}
