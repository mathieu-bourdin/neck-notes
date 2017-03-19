package org.callahan.necknotes.core;

public class HarmonicMinorScale extends RepeatingScale {

  private static final int[] HARMONIC_MINOR_STEPS = {2, 1, 2, 2, 1, 3, 1};

  public HarmonicMinorScale(Tone t) {
    super(t, HARMONIC_MINOR_STEPS);
  }
}
