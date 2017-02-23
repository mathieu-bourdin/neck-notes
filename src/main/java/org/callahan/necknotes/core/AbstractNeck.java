package org.callahan.necknotes.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

abstract class AbstractNeck implements NeckSpecifications {

  static final int DEFAULT_FRETS_COUNT = 22;

  private final List<InstrumentString> strings;
  private List<FretDecoration> decorations;

  AbstractNeck(Note[] rootNotes) {
    AtomicInteger idx = new AtomicInteger(0);
    strings = Arrays
      .stream(Objects.requireNonNull(rootNotes))
      .map(note -> new InstrumentString(note, idx.getAndIncrement()))
      .collect(Collectors.toList());
    decorations = new ArrayList<>();
  }

  @Override
  public List<InstrumentString> getStrings() {
    return strings;
  }

  @Override
  public List<FretDecoration> getFretDecorations() {
    return decorations;
  }

}
