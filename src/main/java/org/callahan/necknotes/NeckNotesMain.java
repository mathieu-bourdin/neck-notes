package org.callahan.necknotes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.callahan.necknotes.components.GuiBuilder;
import org.callahan.necknotes.components.ToneSelectionShortcuts;
import org.callahan.necknotes.components.neck.NeckSpecificationsController;
import org.callahan.necknotes.components.notes.NotesSelectionController;
import org.callahan.necknotes.controllers.Controllers;
import org.callahan.necknotes.core.NeckNotesFacade;
import org.callahan.necknotes.core.Tone;

import java.util.stream.Stream;

public class NeckNotesMain extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
    setup(primaryStage);
  }

  private void setup(Stage stage) {
    stage.setTitle("Neck notes 1.0");
    stage.setMinWidth(640);
    stage.setMinHeight(240);
    stage.getIcons().add(new Image("/img/neck-notes-icon.png"));

    Scene scene = new Scene(new GuiBuilder().build(), 640, 240);
    scene.addEventHandler(
      KeyEvent.KEY_PRESSED,
      ToneSelectionShortcuts.createHandler()
    );

    selectStartingNeckLayout();
    setupStartingSelection();
    stage.setScene(scene);
    stage.show();
  }

  private void setupStartingSelection() {
//    Stream.of(Tone.C, Tone.E, Tone.G).forEach(
//      Controllers.get(NotesSelectionController.class)::toggleTone
//    );
  }

  private void selectStartingNeckLayout() {
    Controllers.get(NeckSpecificationsController.class).changeNeckSpecs(
      NeckNotesFacade.getNeckSpecifications()
    );
  }

}
