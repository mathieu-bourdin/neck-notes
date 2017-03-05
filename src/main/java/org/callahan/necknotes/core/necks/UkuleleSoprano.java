package org.callahan.necknotes.core.necks;

import org.callahan.necknotes.core.EvenNeck;
import org.callahan.necknotes.core.Note;
import org.callahan.necknotes.core.Tone;

public class UkuleleSoprano extends EvenNeck {

  private static final Note[] ZERO_FRET_NOTES = {
    new Note(Tone.A, 4),
    new Note(Tone.E, 4),
    new Note(Tone.C, 4),
    new Note(Tone.G, 4),
  };

  public UkuleleSoprano() {
    super(ZERO_FRET_NOTES);
    setFretsCount(15);
    getStrings().get(0).setGauge(19);
    getStrings().get(1).setGauge(27);
    getStrings().get(2).setGauge(31);
    getStrings().get(3).setGauge(22);
  }

  @Override
  public String getName() {
    return "Ukulele (soprano)";
  }
}
