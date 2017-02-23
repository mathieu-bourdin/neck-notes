package org.callahan.necknotes.core;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class InstrumentString {

  private Note rootNote;
  /**
   * Position of the first fret.
   */
  private int firstFret;

  /**
   * Position of the last fret.
   */
  private int lastFret;

  /**
   * Index of the string (start at 0)
   */
  private int index;

  /**
   * Gauge
   */
  private double gauge;

  public InstrumentString(Note n, int idx) {
    if (index < 0) {
      throw new IllegalArgumentException("String index must be >= 0");
    }
    index = idx;
    rootNote = Objects.requireNonNull(n);
    gauge = 0;
    firstFret = 1;
    lastFret = 12;
  }

  public Note getRootNote() {
    return rootNote;
  }

  public void setRootNote(Note n) {
    Optional.ofNullable(n).ifPresent(x -> rootNote = x);
  }

  public int getIndex() {
    return index;
  }

  public int getFretsCount() {
    return lastFret - firstFret + 1;
  }

  public int getLastFret() {
    return lastFret;
  }

  public void setLastFret(int n) {
    lastFret = max(1, max(n, firstFret));
  }

  public int getFirstFret() {
    return firstFret;
  }

  public void setFirstFret(int n) {
    firstFret = max(1, min(n, lastFret));
  }

  public double getGauge() {
    return gauge;
  }

  public void setGauge(double gauge) {
    this.gauge = gauge;
  }

  public Stream<Note> streamNotes() {
    return Stream.generate(new NotesSupplier(this)).limit(getFretsCount() + 1);
  }

  public Note[] listNotes() {
    return streamNotes().toArray(s -> new Note[s]);
  }

  private static class NotesSupplier implements Supplier<Note> {

    private int noteNumber;

    private NotesSupplier(InstrumentString is) {
      noteNumber = is.getRootNote().asNoteNumber();
    }

    @Override
    public Note get() {
      return new Note(noteNumber++);
    }

  }

}
