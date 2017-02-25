package org.callahan.necknotes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.callahan.necknotes.components.GuiBuilder;

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
    stage.setMinWidth(600);
    stage.setMinHeight(200);
    stage.getIcons().add(new Image("/img/neck-notes-icon.png"));

    Scene scene = new Scene(new GuiBuilder().build(), 640, 240);
    stage.setScene(scene);
    stage.show();
  }

}
