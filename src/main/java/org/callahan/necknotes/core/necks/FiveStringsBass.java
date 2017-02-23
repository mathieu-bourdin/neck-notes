package org.callahan.necknotes.core.necks;

import org.callahan.necknotes.core.EvenNeck;
import org.callahan.necknotes.core.Note;
import org.callahan.necknotes.core.Tone;

public class FiveStringsBass extends EvenNeck {

  private static final Note[] ZERO_FRET_NOTES = {
    new Note(Tone.G, 2),
    new Note(Tone.D, 2),
    new Note(Tone.A, 1),
    new Note(Tone.E, 1),
    new Note(Tone.B, 0),
  };

  public FiveStringsBass() {
    super(ZERO_FRET_NOTES);
    getStrings().get(0).setGauge(40);
    getStrings().get(1).setGauge(60);
    getStrings().get(2).setGauge(80);
    getStrings().get(3).setGauge(100);
    getStrings().get(4).setGauge(125);
  }

  @Override
  public String getName() {
    return "Bass (5 strings)";
  }
}
