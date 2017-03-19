package org.callahan.necknotes.core;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ToneTest {

  @Test
  public void givenOrder_getTone() {
    assertThat(Tone.fromOrder(0), is(Tone.C));
    assertThat(Tone.fromOrder(1), is(Tone.C_SHARP));
    assertThat(Tone.fromOrder(-1), is(Tone.B));
    assertThat(Tone.fromOrder(-13), is(Tone.B));
    assertThat(Tone.fromOrder(27), is(Tone.D_SHARP));
  }
}