package org.callahan.necknotes.core;

/**
 * A neck with the same count of frets on all strings.
 */
public abstract class EvenNeck extends AbstractNeck {


  public EvenNeck(Note[] rootNotes) {
    super(rootNotes);
    setFretsCount(DEFAULT_FRETS_COUNT);
  }

  public void setFretsCount(int count) {
    if (count >= 0) {
      getStrings().forEach(s -> s.setLastFret(count));
      setupFretsDecorations(count);
    }
  }

  private void setupFretsDecorations(int fretsCount) {
    for (int i = 0; i < fretsCount; ++i) {
      int dots = countDotsOnFret(i);
      if (dots != 0) {
        getFretDecorations().add(new FretDecoration(i, dots));
      }
    }
  }

  private int countDotsOnFret(int f) {
    int m = f % 12;
    if (m == 3 || m == 5 || m == 7 || m == 9) {
      return 1;
    } else if (m == 0 && f > 0) {
      return 2;
    } else {
      return 0;
    }
  }
}
