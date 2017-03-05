package org.callahan.necknotes.components.utils;

public class Doubles {

  public static final double EPSILON = 0.00001;

  public static boolean equal(double a, double b) {
    return Math.abs(a - b) < EPSILON;
  }

}
