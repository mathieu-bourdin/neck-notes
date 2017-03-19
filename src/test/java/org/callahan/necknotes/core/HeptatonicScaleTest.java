package org.callahan.necknotes.core;

import org.junit.Test;

import static org.callahan.necknotes.core.Tone.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HeptatonicScaleTest extends AbstractScaleTest {

  @Test
  public void givenRootTone_createIonianScale() {
    HeptatonicScale s = new HeptatonicScale(C);
    assertThat(s.getRoot(), is(C));
    assertPitches(s, C, D, E, F, G, A, B, C);
    assertThat(s.getPitch(7), is(C));
    assertThat(s.getPitch(-1), is(B));
  }

  @Test
  public void givenRootTone_createDorianScale() {
    HeptatonicScale s = new HeptatonicScale(D, HeptatonicMode.DORIAN);
    assertPitches(s, D, E, F, G, A, B, C, D);
  }

  @Test
  public void givenRootTone_createLydianScale() {
    HeptatonicScale s = new HeptatonicScale(C, HeptatonicMode.LYDIAN);
    assertPitches(s, C, D, E, F_SHARP, G, A, B, C);
  }

  @Test
  public void givenScale_getDegrees() {
    HeptatonicScale s = new HeptatonicScale(F, HeptatonicMode.AEOLIAN);
    assertThat(s.getTonic(), is(Tone.F));
    assertThat(s.getSupertonic(), is(Tone.G));
    assertThat(s.getMediant(), is(Tone.G_SHARP));
    assertThat(s.getSubdominant(), is(Tone.A_SHARP));
    assertThat(s.getDominant(), is(Tone.C));
    assertThat(s.getSubmediant(), is(Tone.C_SHARP));
    assertThat(s.getLeadingTone(), is(Tone.D_SHARP));
  }

}