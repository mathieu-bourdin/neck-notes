package org.callahan.necknotes.core;

public enum HeptatonicMode {

  IONIAN(0),
  DORIAN(1),
  PHRYGIAN(2),
  LYDIAN(3),
  MIXOLYDIAN(4),
  AEOLIAN(5),
  LOCIRAN(6);

  private static final int[] IONIAN_STEPS = {2, 2, 1, 2, 2, 2, 1};
  private final int shift;

  HeptatonicMode(int s) {
    shift = s;
  }

  public int[] getSteps() {
    int[] res = new int[7];
    for (int i = 0; i < 7; ++i) {
      res[i] = IONIAN_STEPS[(i+shift) % 7];
    }
    return res;
  }


}
