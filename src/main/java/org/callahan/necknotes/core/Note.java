package org.callahan.necknotes.core;

import java.util.Objects;

public class Note implements Comparable<Note> {

  private final Tone tone;

  private final int octave;


  public Note(Tone t, int octave) {
    this.tone = Objects.requireNonNull(t);
    this.octave = octave;
  }

  public Note(int noteNumber) {
    this.octave = noteNumber / 12;
    this.tone = Tone.fromOrder(noteNumber % 12);
  }


  public int asNoteNumber() {
    return octave * 12 + tone.getOrder();
  }

  public int substract(Note n) {
    return asNoteNumber() - n.asNoteNumber();
  }

  public String toneLabel() {
    return tone.getLabel();
  }

  public Tone getTone() {
    return tone;
  }

  public Note add(int i) {
    return new Note(asNoteNumber() + i);
  }

  @Override
  public int compareTo(Note other) {
    return asNoteNumber() - other.asNoteNumber();
  }

  @Override
  public String toString() {
    return tone.name() + octave;
  }
}
