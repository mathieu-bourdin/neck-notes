package org.callahan.necknotes.core.necks;

import org.callahan.necknotes.core.*;

import java.util.Arrays;
import java.util.List;

public class TestInstrument implements NeckSpecifications {

  private final List<InstrumentString> strings;
  private final List<FretDecoration> decorations;
  private int stringIndex;

  public TestInstrument() {
    stringIndex = 0;
    strings = Arrays.asList(
      createString(Tone.C, 7, 7, 0),
      createString(Tone.D, 1, 1, 0),
      createString(Tone.E, 3, 3, -8000),
      createString(Tone.F, 1, 2, 0),
      createString(Tone.G, 2, 4, 500),
      createString(Tone.A, 1, 7, 1000)
    );
    decorations = Arrays.asList(
      new FretDecoration(1, 6),
      new FretDecoration(5, 1),
      new FretDecoration(6, 0),
      new FretDecoration(7, 20),
      new FretDecoration(8, 100000)

    );
  }

  private InstrumentString createString(Tone t, int firstF, int endF, double gauge) {
    InstrumentString res = new InstrumentString(new Note(t, 5), stringIndex++);
    res.setGauge(gauge);
    res.setFirstFret(firstF);
    res.setLastFret(endF);
    return res;
  }

  @Override
  public List<InstrumentString> getStrings() {
    return strings;
  }

  @Override
  public List<FretDecoration> getFretDecorations() {
    return decorations;
  }

  @Override
  public String getName() {
    return "Stupid test instrument";
  }
}
