package org.callahan.necknotes.core.scales;

import org.junit.Test;

import static org.callahan.necknotes.core.Tone.*;

public class MinorScalesTest extends AbstractScaleTest {

  @Test
  public void createHarmonicMinorScale() {
    HarmonicMinorScale s = new HarmonicMinorScale(A);
    assertPitches(s, A, B, C, D, E, F, G_SHARP);
  }

  @Test
  public void createNaturalMinorScale() {
    NaturalMinorScale s = new NaturalMinorScale(A);
    assertPitches(s, A, B, C, D, E, F, G);
  }

  @Test
  public void createMelodicMinorUpScale() {
    MelodicMinorUpScale s = new MelodicMinorUpScale(A);
    assertPitches(s, A, B, C, D, E, F_SHARP, G_SHARP, A);
  }

  @Test
  public void createMelodicMinorDownScale() {
    MelodicMinorDownScale s = new MelodicMinorDownScale(A);
    assertPitches(s, A, G, F, E, D, C, B, A);
  }
}
