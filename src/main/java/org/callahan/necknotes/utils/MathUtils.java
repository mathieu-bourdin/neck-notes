package org.callahan.necknotes.utils;

public class MathUtils {

  /**
   * Proper positive modulo.
   */
  public static int mod(int i, int j) {
    int r = i % j;
    if (i < 0) {
      r += j;
    }
    return r;
  }

}
