package org.callahan.necknotes.core;

import java.util.Arrays;

public enum Tone {

  A("A", 9),
  A_SHARP("A#", 10),
  B("B", 11),
  C("C", 0),
  C_SHARP("C#", 1),
  D("D", 2),
  D_SHARP("D#", 3),
  E("E", 4),
  F("F", 5),
  F_SHARP("F#", 6),
  G("G", 7),
  G_SHARP("G#", 8);

  public static final Tone[] CHROMATIC =
    { C, C_SHARP, D, D_SHARP, E, F, F_SHARP, G, G_SHARP, A, A_SHARP, B };

  public static final Tone[] FIFTHS =
    {A, E, B, F_SHARP, C_SHARP, G_SHARP, D_SHARP, A_SHARP, F, C, G, D};

  public static final Tone[] FOURTHS =
    {A, D, G, C, F, A_SHARP, D_SHARP, G_SHARP, C_SHARP, F_SHARP, B, E};

  Tone(String l, int o) {
    label = l;
    order = o;
  }

  private String label;
  private int order;

  public static Tone fromOrder(int o) {
    return Arrays.stream(Tone.values())
      .filter(t -> t.order == o)
      .findFirst()
      .orElseThrow(() ->
        new IllegalArgumentException("Invalid tone order: " + o));
  }

  public int getOrder() {
    return order;
  }

  public String getLabel() {
    return label;
  }

  @Override
  public String toString() {
    return getLabel();
  }

}
