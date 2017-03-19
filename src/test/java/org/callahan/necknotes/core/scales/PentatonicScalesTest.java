package org.callahan.necknotes.core.scales;

import org.callahan.necknotes.core.Tone;
import org.junit.Test;

public class PentatonicScalesTest extends AbstractScaleTest {

  @Test
  public void createMinor() {
    PentatonicMinorScale s = new PentatonicMinorScale(Tone.D_SHARP);
    assertPitches(s, Tone.D_SHARP, Tone.F_SHARP, Tone.G_SHARP, Tone.A_SHARP, Tone.C_SHARP, Tone.D_SHARP);
  }

  @Test
  public void createMajor() {
    PentatonicMajorScale s = new PentatonicMajorScale(Tone.F_SHARP);
    assertPitches(s, Tone.F_SHARP, Tone.G_SHARP, Tone.A_SHARP, Tone.C_SHARP, Tone.D_SHARP, Tone.F_SHARP);
  }
}
