package org.callahan.necknotes.core;

/**
 * Decorative thingy behind a fret.
 */
public class FretDecoration {

  private final int fretIndex;
  private final int decorationId;

  public FretDecoration(int index, int id) {
    if (index < 1) {
      throw new IllegalArgumentException("fret index must be >= 1");
    }
    fretIndex = index;
    decorationId = id;
  }

  public int getFretIndex() {
    return fretIndex;
  }

  public int getDecorationId() {
    return decorationId;
  }

}
