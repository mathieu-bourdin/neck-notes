package org.callahan.necknotes.components.neck;

import org.callahan.necknotes.core.Note;
import org.callahan.necknotes.core.Tone;

class FretCell {

  final Note note;
  final int row;
  final int column;

  FretCell(Note n, int r, int c) {
    note = n;
    row = r;
    column = c;
  }

  boolean matchesTone(Tone t) {
    return note.getTone() == t;
  }

  public Tone getTone() {
    return note.getTone();
  }
}
