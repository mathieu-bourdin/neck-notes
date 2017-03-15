package org.callahan.necknotes.components.neck;

import javafx.scene.layout.Region;
import org.callahan.necknotes.components.notes.NotesSelectionController;
import org.callahan.necknotes.controllers.Controllers;
import org.callahan.necknotes.core.NeckNotesFacade;

public class FrettedNotes extends Region {


  private FretBoardContext context;
  private double radius;
  private double shiftX;
  private double shiftY;

  public FrettedNotes() {
    Controllers.get(NeckSpecificationsController.class)
      .addListener(this::updateSpecs);
    Controllers.get(NotesSelectionController.class)
      .addListener(e -> updateNotes());
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

}
