package org.callahan.necknotes.core.scales;

import org.callahan.necknotes.core.Tone;

public class PentatonicMajorScale extends RepeatingScale {

  private static final int[] PENTATONIC_MAJOR_STEPS = {2, 2, 3, 2, 3};

  public PentatonicMajorScale(Tone rootTone) {
    super(rootTone, PENTATONIC_MAJOR_STEPS);
  }
}
