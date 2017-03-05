package org.callahan.necknotes.components.notes;

import javafx.geometry.Insets;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import org.callahan.necknotes.components.FretBoardColors;
import org.callahan.necknotes.controllers.Controllers;
import org.callahan.necknotes.core.NeckNotesFacade;
import org.callahan.necknotes.core.Tone;

class ToneButton extends ToggleButton {

  private static final double CORNER_RADIUS = 4.0;

  private final Tone tone;

  ToneButton(Tone t) {
    super(t.getLabel());
    tone = t;
    HBox.setHgrow(this, Priority.ALWAYS);
    setMaxWidth(Double.MAX_VALUE);
    setPrefWidth(32);
    setFocusTraversable(false);
    setupEventsManagement();
    updateColors();
  }

  private void updateColors() {
    setTextFill(createTextFill());
    setBackground(createBackground());
    setBorder(createBorder());
  }

  private Paint createTextFill() {
    if (isSelected()) {
      return FretBoardColors.DEFAULT.getFrettedNoteBackground();
    } else {
      return FretBoardColors.DEFAULT.getFrettedNoteForeground();
    }
  }

  private void setupEventsManagement() {
    setupAction();
    observeController();
  }

  private void observeController() {
    Controllers.get(NotesSelectionController.class)
      .addListener(e -> {
        if (e.getTone() == tone) {
          setSelected(NeckNotesFacade.isSelected(tone));
          updateColors();
        }
      });
  }

  private void setupAction() {
    setOnAction(evt ->
      Controllers.get(NotesSelectionController.class).toggleTone(tone)
    );
  }

  @Override
  public String toString() {
    return tone.getLabel();
  }


  private Background createBackground() {
    return new Background(
      new BackgroundFill(
        getBgColor(),
        new CornerRadii(CORNER_RADIUS),
        new Insets(0.0)
      )
    );
  }

  private Paint getBgColor() {
    if (isSelected()) {
      return FretBoardColors.DEFAULT.getFrettedNoteForeground();
    } else {
      return FretBoardColors.DEFAULT.getFrettedNoteBackground();
    }
  }

  private Paint getFgColor() {
    if (isSelected()) {
      return FretBoardColors.DEFAULT.getFrettedNoteBackground();
    } else {
      return FretBoardColors.DEFAULT.getFrettedNoteForeground();
    }
  }

  private Border createBorder() {
    return new Border(
      new BorderStroke(
        FretBoardColors.DEFAULT.getFrettedNoteForeground(),
        BorderStrokeStyle.SOLID,
        new CornerRadii(CORNER_RADIUS),
        new BorderWidths(1.0)
      )
    );
  }

  public Tone getTone() {
    return tone;
  }
}
