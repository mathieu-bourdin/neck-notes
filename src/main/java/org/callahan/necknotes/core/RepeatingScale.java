package org.callahan.necknotes.core;

import org.callahan.necknotes.utils.MathUtils;

public abstract class RepeatingScale {

  protected final Tone root;
  private final int[] rootDistances;

  public RepeatingScale(Tone rootTone, int[] steps) {
    root = rootTone;
    rootDistances = computeDistances(steps);
  }

  private int[] computeDistances(int[] steps) {
    int[] res = new int[steps.length];
    int dist = 0;
    for (int i = 0; i < steps.length; ++i) {
      res[i] = dist;
      dist += steps[i];
    }
    return res;
  }

  public Tone getRoot() {
    return getPitch(0);
  }

  public Tone getPitch(int i) {
    return Tone.fromOrder(
      root.getOrder() + rootDistances[MathUtils.mod(i, rootDistances.length)]
    );
  }


}
