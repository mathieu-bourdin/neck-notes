package org.callahan.necknotes.core.necks;

import org.callahan.necknotes.core.EvenNeck;
import org.callahan.necknotes.core.InstrumentString;
import org.callahan.necknotes.core.Note;
import org.callahan.necknotes.core.Tone;

public class GuitarStandard extends EvenNeck {

  private static final Note[] ZERO_FRET_NOTES = {
    new Note(Tone.E, 4),
    new Note(Tone.B, 3),
    new Note(Tone.G, 3),
    new Note(Tone.D, 3),
    new Note(Tone.A, 2),
    new Note(Tone.E, 2)
  };

  public GuitarStandard() {
    super(ZERO_FRET_NOTES);
    getStrings().get(0).setGauge(9);
    getStrings().get(1).setGauge(11);
    getStrings().get(2).setGauge(16);
    getStrings().get(3).setGauge(26);
    getStrings().get(4).setGauge(36);
    getStrings().get(5).setGauge(46);
  }

  @Override
  public String getName() {
    return "Guitar";
  }
}
