package org.callahan.necknotes.components.neck;

import javafx.scene.layout.Region;
import org.callahan.necknotes.components.notes.NotesSelectionController;
import org.callahan.necknotes.components.notes.ToggleToneEvent;
import org.callahan.necknotes.controllers.Controllers;
import org.callahan.necknotes.core.NeckNotesFacade;

public class FrettedNotes extends Region {


  private FretBoardContext context;
  private FrettedNoteButton[][] buttons;
  private double radius;
  private double shiftX;
  private double shiftY;

  public FrettedNotes() {
    Controllers.get(NeckSpecificationsController.class)
      .addListener(this::updateSpecs);
    Controllers.get(NotesSelectionController.class)
      .addListener(this::updateNotes);
  }

  private void updateNotes(ToggleToneEvent toggleToneEvent) {
    updateNotes();
  }

  private void updateSpecs(NeckSpecsChangedEvent evt) {
    context = evt.getUpdatedContext();
    updateNotes();
  }

  private void updateNotes() {
    getChildren().clear();
    context.streamCells()
      .filter(c -> NeckNotesFacade.getSelectedTones().contains(c.getTone()))
      .map(FrettedNoteButton::new)
      .forEach(getChildren()::add);
  }

//    for (int i = 0; i < rows; ++i) {
//      for (int j = 0; j < cols; ++j) {
//        getChildren().add(new FrettedNoteButton("Mm"));
//      }
//    }
//  }

  @Override
  protected void layoutChildren() {
    if (getChildren().size() > 0) {
      radius = 0.8 * Math.min(context.cellW, context.cellH) / 2.0;
      radius = Math.max(getChildren().get(0).minWidth(radius), radius);
      shiftX = context.cellW / 2.0 - radius;
      shiftY = context.cellH / 2.0 - radius;
      getChildren().stream()
        .map(n -> (FrettedNoteButton) n)
        .forEach(this::layout);
    }
  }

  private void layout(FrettedNoteButton fnb) {
    double x = context.cellW * fnb.getColumn() + shiftX;
    double y = context.cellH * fnb.getRow() + shiftY;
    fnb.setLayoutX(x);
    fnb.setLayoutY(y);
    fnb.resize(radius * 2, radius * 2);
    fnb.updateFontSize();
  }


//  protected void layoutChildrenOld() {
//    int i = 0;
//    double scale = 0.8;
//    double cellW = getWidth() / cols;
//    double cellH = getHeight() / rows;
//    double radius = scale * Math.min(cellW, cellH) / 2.0;
//    radius = Math.max(getChildren().get(0).minWidth(radius), radius);
//    double shiftY = cellH / 2.0 - radius;
//    double shiftX = cellW / 2.0 - radius;
//
//    for (Node n : getChildren()) {
//      FrettedNoteButton b = (FrettedNoteButton) n;
//      double x = cellW * (i % cols) + shiftX;
//      double y = cellH * (i / cols) + shiftY;
//      b.setLayoutX(x);
//      b.setLayoutY(y);
//      b.resize(radius * 2, radius * 2);
//      b.updateFontSize();
//      ++i;
//    }
//  }
}
