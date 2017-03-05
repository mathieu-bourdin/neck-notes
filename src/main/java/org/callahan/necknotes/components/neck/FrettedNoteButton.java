package org.callahan.necknotes.components.neck;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.CornerRadii;
import javafx.scene.shape.Circle;
import org.callahan.necknotes.components.FretBoardColors;
import org.callahan.necknotes.components.utils.BorderFactory;

public class FrettedNoteButton extends Button {

  private static final double FONT_SCALE = 0.035;
  private final FretCell cell;
  private static final double MIN_WIDTH = 12.0;

  public FrettedNoteButton(FretCell fc) {
    super(fc.note.toneLabel());
    cell = fc;
    setPadding(Insets.EMPTY);
    setMinSize(MIN_WIDTH, MIN_WIDTH);
    setFocusTraversable(false);
    Circle c = new Circle(MIN_WIDTH / 2.0);
    setShape(c);
    setBackground(createBackground());
    setTextFill(FretBoardColors.DEFAULT.getFrettedNoteForeground());
    setBorder(createBorder());
  }

  public void updateFontSize() {
    Node tn = lookup(".text");
    tn.setScaleX(getWidth() * FONT_SCALE);
    tn.setScaleY(getHeight() * FONT_SCALE);
  }

  public int getRow() {
    return cell.row;
  }

  public int getColumn() {
    return cell.column;
  }

  private Border createBorder() {
    return BorderFactory.create(FretBoardColors.DEFAULT.getFrettedNoteForeground(), 2.0);
  }

  private Background createBackground() {
    return new Background(
      new BackgroundFill(
        FretBoardColors.DEFAULT.getFrettedNoteBackground(),
        CornerRadii.EMPTY,
        new Insets(1.0)
      )
    );
  }

}
