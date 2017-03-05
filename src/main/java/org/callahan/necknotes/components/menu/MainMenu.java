package org.callahan.necknotes.components.menu;

import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.callahan.necknotes.components.FretBoardColors;
import org.callahan.necknotes.components.neck.NeckSpecificationsController;
import org.callahan.necknotes.components.utils.IconColorizer;
import org.callahan.necknotes.controllers.Controllers;
import org.callahan.necknotes.core.NeckNotesFacade;
import org.callahan.necknotes.core.NeckSpecifications;

import static org.callahan.necknotes.core.NeckNotesFacade.getNeckSpecifications;

public class MainMenu extends Button {

  public MainMenu() {
    setGraphic(createIcon());
    setPadding(new Insets(2));
    setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    ContextMenu cm = new ContextMenu();
    appendPresets(cm);
    setOnAction(e -> cm.show(this, Side.RIGHT, 0, 0));
    setFocusTraversable(false);
  }

  private Node createIcon() {
    ImageView iv = new ImageView(colorize("/img/cog.png"));
    iv.setFitHeight(22);
    iv.setFitWidth(22);
    return iv;
  }

  private Image colorize(String resource) {
    return IconColorizer.colorize(
      resource,
      FretBoardColors.DEFAULT.getFrettedNoteForeground()
    );
  }

  private void appendPresets(ContextMenu cm) {
    ToggleGroup group = new ToggleGroup();
    NeckNotesFacade.factoryPresets().stream()
      .map(s -> createPresetItem(s, group))
      .forEach(cm.getItems()::add);
  }

  private MenuItem createPresetItem(NeckSpecifications s, ToggleGroup group) {
    RadioMenuItem it = new RadioMenuItem(s.getName());
    it.setToggleGroup(group);
    it.setSelected(s.getName().equals(getNeckSpecifications().getName()));
    it.setOnAction(e ->
      Controllers.get(NeckSpecificationsController.class).changeNeckSpecs(s)
    );
    return it;
  }

}
