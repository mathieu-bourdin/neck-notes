package org.callahan.necknotes.components.notes;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
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
    while (n != null && !(n instanceof ToneButton)) {
      n = n.getParent();
    }
    return Optional.ofNullable((ToneButton) n);
  }


}
