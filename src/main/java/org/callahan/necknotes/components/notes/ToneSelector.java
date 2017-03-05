package org.callahan.necknotes.components.notes;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import org.callahan.necknotes.core.NeckNotesFacade;

import java.util.Optional;
import java.util.stream.Collectors;

public class ToneSelector extends HBox {

  private static final double SPACE = 4;

  private boolean dragState = false;

  public ToneSelector() {
    setSpacing(SPACE);
    setPadding(new Insets(SPACE));
    getChildren().addAll(
      NeckNotesFacade.getTonesOrder().stream()
      .map(ToneButton::new)
      .collect(Collectors.toList())
    );
    addEventFilter(MouseEvent.ANY, this::mouseFilter);
  }

  void setDragState(boolean b) {
    dragState = b;
  }

  boolean getDragState() {
    return dragState;
  }

  private void mouseFilter(MouseEvent evt) {
    getButtonUnderMouse(evt).ifPresent(bt -> {
      if (evt.getEventType() == MouseEvent.MOUSE_PRESSED) {
        dragState = !bt.isSelected();
        bt.fire();
      } else if (evt.getEventType() == MouseEvent.MOUSE_DRAGGED) {
        if (bt.isSelected() != getDragState()) {
          bt.fire();
        }
      }
    });
    evt.consume();
  }

  Optional<ToneButton> getButtonUnderMouse(MouseEvent evt) {
    Node n = evt.getPickResult().getIntersectedNode();
    if (n instanceof Text) {
      return Optional.of((ToneButton) n.getParent());
    } else if (n instanceof ToneButton) {
      return Optional.of((ToneButton) n);
    } else {
      return Optional.empty();
    }
  }


}
