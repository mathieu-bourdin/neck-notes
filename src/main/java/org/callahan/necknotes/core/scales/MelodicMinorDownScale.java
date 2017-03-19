package org.callahan.necknotes.core.scales;

import org.callahan.necknotes.core.Tone;

public class MelodicMinorDownScale extends RepeatingScale {


  private static int[] MELODIC_MINOR_SCALE_DOWN = {-2, -2, -1, -2, -2, -1, -2};

  public MelodicMinorDownScale(Tone rootTone) {
    super(rootTone, MELODIC_MINOR_SCALE_DOWN);
  }
  
}
