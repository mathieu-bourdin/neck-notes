package org.callahan.necknotes.components.neck;

import org.callahan.necknotes.core.InstrumentString;
import org.callahan.necknotes.core.NeckSpecifications;
import org.callahan.necknotes.core.Note;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.*;
import java.util.List;
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
  private Dimension currentSize;
  private double gaugeRatio;

  FretBoardContext(NeckSpecifications layout) {
    neckSpec = Objects.requireNonNull(layout);
    columns = lastFret();
    rows = neckSpec.getStrings().size();
    cells = initCells();
    currentSize = new Dimension(0, 0);
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

  void updateSize(Dimension d) {
    if (sizeChanged(d)) {
      width = d.getWidth();
      height = d.getHeight();
      cellW = width / ((double) columns);
      cellH = height / ((double) rows);
      cellMinEdge = min(cellH, cellW);
    }
  }

  private boolean sizeChanged(Dimension d) {
    if (d.equals(currentSize)) {
      return false;
    } else {
      currentSize = d;
      return true;
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
      for (Note n : string.streamNotes().skip(1).toArray(s -> new Note[s])) {
        res[idx] = new FretCell(n, idx / columns, idx % columns);
        ++idx;
      }
    }
    return res;
  }

  public Stream<FretCell> streamCells() {
    return Arrays.stream(cells).filter(c -> c != null);
  }
}
