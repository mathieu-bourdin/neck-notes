package org.callahan.necknotes.core.scales;

import org.callahan.necknotes.core.Tone;

public class MelodicMinorUpScale extends RepeatingScale {


  private static int[] MELODIC_MINOR_SCALE_UP = {2, 1, 2, 2, 2, 2, 1};

  public MelodicMinorUpScale(Tone rootTone) {
    super(rootTone, MELODIC_MINOR_SCALE_UP);
  }

}
