package org.callahan.necknotes.core.necks;

import org.callahan.necknotes.core.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BanjoFiveStrings implements NeckSpecifications {

  private static final List<Integer> dottedFrets =
    Arrays.asList(3, 5, 7, 10, 12, 15, 17);

  private List<InstrumentString> strings;
  private List<FretDecoration> dots;

  public BanjoFiveStrings() {
    strings = createStrings();
    dots = createDots();
    getStrings().get(0).setGauge(10);
    getStrings().get(1).setGauge(11);
    getStrings().get(2).setGauge(12);
    getStrings().get(3).setGauge(20);
    getStrings().get(4).setGauge(10);
  }

  @Override
  public String getName() {
    return "Banjo (5 strings)";
  }

  @Override
  public List<InstrumentString> getStrings() {
    return strings;
  }

  @Override
  public List<FretDecoration> getFretDecorations() {
    return dots;
  }

  private List<FretDecoration> createDots() {
    return dottedFrets.stream()
      .map(i -> new FretDecoration(i, 1))
      .collect(Collectors.toList());
  }

  private List<InstrumentString> createStrings() {
    List<InstrumentString> res = new ArrayList<>();
    res.add(regularString(Tone.D, 4, 0));
    res.add(regularString(Tone.B, 3, 1));
    res.add(regularString(Tone.G, 3, 2));
    res.add(regularString(Tone.D, 3, 3));
    res.add(shortString(4));
    return res;
  }

  private InstrumentString regularString(Tone d, int octave, int index) {
    return new InstrumentString(new Note(d, octave), index);
  }

  private InstrumentString shortString(int index) {
    InstrumentString res = new InstrumentString(new Note(Tone.G, 4), index);
    res.setFirstFret(6);
    return res;
  }

}
