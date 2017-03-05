package org.callahan.necknotes.components.neck;

import org.callahan.necknotes.components.utils.Doubles;
import org.callahan.necknotes.core.InstrumentString;
import org.callahan.necknotes.core.NeckSpecifications;
import org.callahan.necknotes.core.Note;

import java.util.*;
import java.util.stream.Stream;

import static java.lang.Math.min;
import static java.util.stream.Collectors.toList;

public class FretBoardContext {

  double cellW;
  double cellH;
  double cellMinEdge;
  double width;
  double height;

  public final NeckSpecifications neckSpec; // What did you neck spec ?
  final int columns;
  final int rows;
  private final FretCell[] cells;
  private double gaugeRatio;

  FretBoardContext(NeckSpecifications layout) {
    neckSpec = Objects.requireNonNull(layout);
    columns = lastFret();
    rows = neckSpec.getStrings().size();
    cells = initCells();
    gaugeRatio = calcGaugeRatio();
  }

  private int lastFret() {
    return neckSpec.getStrings().stream()
      .map(InstrumentString::getLastFret)
      .max(Integer::compare)
      .orElse(0);
  }


  private double calcGaugeRatio() {
    List<Double> gauges = neckSpec.getStrings().stream()
      .map(InstrumentString::getGauge).collect(toList());
    double minGauge = Math.max(Collections.min(gauges), 1.0) - 1.0;
    double maxGauge = Math.max(Collections.max(gauges), minGauge) - 1.0;
    return FretBoardMetrics.STRING_WIDTH_CELL_RATIO / maxGauge;
  }

  double gaugeToPixels(double gauge) {
    return Math.max(1.0, gauge * gaugeRatio * cellH);
  }

  Optional<FretCell> getFretCell(int string, int fret) {
    return Optional.ofNullable(cells[string * columns + fret]);
  }

  void updateSize(double w, double h) {
//    if (sizeChanged(w, h)) {
      width = w;
      height = h;
      cellW = width / ((double) columns);
      cellH = height / ((double) rows);
      cellMinEdge = min(cellH, cellW);
//    }
  }

  private boolean sizeChanged(double w, double h) {
    if (Doubles.equal(w, width) && Doubles.equal(h, height)) {
      return true;
    } else {
      width = w;
      height = h;
      return false;
    }
  }

  double fretCenterX(int fretIndex) {
    return cellW * (fretIndex - 0.5);
  }

  double fretCenterY(int stringIndex) {
    return cellH * (stringIndex + 0.5);
  }


  private FretCell[] initCells() {
    FretCell[] res = new FretCell[columns * rows];
    int idx = 0;
    for (InstrumentString string : neckSpec.getStrings()) {
      idx += string.getFirstFret() - 1;
      for (Note n : string.streamNotes().skip(1).toArray(Note[]::new)) {
        res[idx] = new FretCell(n, idx / columns, idx % columns);
        ++idx;
      }
    }
    return res;
  }

  public Stream<FretCell> streamCells() {
    return Arrays.stream(cells).filter(Objects::nonNull);
  }
}
