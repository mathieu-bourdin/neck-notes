package org.callahan.necknotes.core;

public class HeptatonicScale extends RepeatingScale {

  public HeptatonicScale(Tone rootTone) {
    this(rootTone, HeptatonicMode.IONIAN);
  }

  public HeptatonicScale(Tone rootTone, HeptatonicMode mode) {
    super(rootTone, mode.getSteps());
  }

  public Tone getTonic() {
    return getPitch(0);
  }

  public Tone getSupertonic() {
    return getPitch(1);
  }

  public Tone getMediant() {
    return getPitch(2);
  }

  public Tone getSubdominant() {
    return getPitch(3);
  }

  public Tone getDominant() {
    return getPitch(4);
  }

  public Tone getSubmediant() {
    return getPitch(5);
  }

  public Tone getLeadingTone() {
    return getPitch(6);
  }


}
