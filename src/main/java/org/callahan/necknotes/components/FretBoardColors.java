package org.callahan.necknotes.components;

import javafx.scene.paint.Color;

public class FretBoardColors {

  public static final FretBoardColors DEFAULT = new FretBoardColors();

  private Color neck = Color.valueOf("#0e4176");
  private Color dots = Color.valueOf("#185696");
  private Color fret = Color.valueOf("#9bcbfd");
  private Color string = Color.valueOf("#0080ff");

  private Color frettedNoteBackground = Color.valueOf("#ffffff");
  private Color frettedNoteForeground = Color.valueOf("#0080ff");

  public Color getNeck() {
    return neck;
  }

  public void setNeck(Color neck) {
    this.neck = neck;
  }

  public Color getDots() {
    return dots;
  }

  public void setDots(Color dots) {
    this.dots = dots;
  }

  public Color getFret() {
    return fret;
  }

  public void setFret(Color fret) {
    this.fret = fret;
  }

  public Color getString() {
    return string;
  }

  public void setString(Color string) {
    this.string = string;
  }

  public Color getFrettedNoteBackground() {
    return frettedNoteBackground;
  }

  public void setFrettedNoteBackground(Color frettedNoteBackground) {
    this.frettedNoteBackground = frettedNoteBackground;
  }

  public Color getFrettedNoteForeground() {
    return frettedNoteForeground;
  }

  public void setFrettedNoteForeground(Color frettedNoteForeground) {
    this.frettedNoteForeground = frettedNoteForeground;
  }
}
