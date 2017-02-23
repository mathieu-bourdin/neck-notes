package org.callahan.necknotes.core.necks;

import org.callahan.necknotes.core.EvenNeck;
import org.callahan.necknotes.core.Note;
import org.callahan.necknotes.core.Tone;

public class Ukulele extends EvenNeck {

  private static final Note[] ZERO_FRET_NOTES = {
    new Note(Tone.A, 4),
    new Note(Tone.E, 4),
    new Note(Tone.C, 4),
    new Note(Tone.G, 4),
  };

  public Ukulele() {
    super(ZERO_FRET_NOTES);
    setFretsCount(15);
  }

  @Override
  public String getName() {
    return "Ukulele";
  }
}
