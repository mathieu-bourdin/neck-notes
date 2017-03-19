package org.callahan.necknotes.core;

public class PentatonicMinorScale extends RepeatingScale {

  private static final int[] PENTATONIC_MINOR_STEPS = {3, 2, 2, 3, 2};

  public PentatonicMinorScale(Tone rootTone) {
    super(rootTone, PENTATONIC_MINOR_STEPS);
  }
}
