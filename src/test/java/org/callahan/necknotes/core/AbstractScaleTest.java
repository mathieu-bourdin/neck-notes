package org.callahan.necknotes.core;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public abstract class AbstractScaleTest {

  protected void assertPitches(RepeatingScale ds, Tone... pitches) {
    for(int i = 0; i < pitches.length; ++i) {
      assertThat(ds.getPitch(i), is(pitches[i]));
    }
  }

}
