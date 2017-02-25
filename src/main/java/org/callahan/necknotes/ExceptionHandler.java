package org.callahan.necknotes;

import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

  @Override
  public void uncaughtException(Thread t, Throwable e) {
    System.err.println("Unexpected error:");
    e.printStackTrace(System.err);
    Alert al = new Alert(Alert.AlertType.ERROR);
    al.setTitle("Unexpected error");
    al.setHeaderText("Oops!");
    al.setContentText("Looks like you found a bug");
    TextArea content = new TextArea("You may want to restart this app, or continue at your own risks :)");
    content.setWrapText(true);
    content.setEditable(false);
    al.getDialogPane().setContent(content);
    al.showAndWait();
  }
}
