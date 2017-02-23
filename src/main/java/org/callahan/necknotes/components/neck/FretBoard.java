package org.callahan.necknotes.components.neck;

import org.callahan.necknotes.Main;
import org.callahan.necknotes.components.notes.NotesSelectionController;
import org.callahan.necknotes.components.tuning.TuningController;
import org.callahan.necknotes.components.utils.Controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

public class FretBoard extends NeckPartComponent implements PropertyChangeListener {

  private FretBoardContext context;

  public FretBoard() {
    Controllers.get(NotesSelectionController.class).addListener(this);
    Controllers.get(TuningController.class).addListener(this);
    setMinimumSize(new Dimension(400, 150));
  }

  @Override
  public void neckPropertiesChanged(FretBoardContext ctx) {
    context = ctx;
    repaint();
  }

  @Override
  public void paintComponent(Graphics g) {
    context.updateSize(getSize());
    new FretBoardDrawer(g, context).draw();
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    // update according to notes selection.
    repaint();
  }

}
