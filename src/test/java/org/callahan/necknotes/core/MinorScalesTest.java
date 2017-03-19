package org.callahan.necknotes.core;

import org.junit.Test;

import static org.callahan.necknotes.core.Tone.*;

public class MinorScalesTest extends AbstractScaleTest {

  @Test
  public void createHarmonicMinorScale() {
    HarmonicMinorScale s = new HarmonicMinorScale(A);
    assertPitches(s, A, B, C, D, E, F, G_SHARP);
  }

  @Test
  public void createMelodicMinorScale() {
    NaturalMinorScale s = new NaturalMinorScale(A);
    assertPitches(s, A, B, C, D, E, F, G);
  }
}
