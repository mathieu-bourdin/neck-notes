package org.callahan.necknotes;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainGridTest extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }
  @Override
  public void start(final Stage primaryStage) {
    primaryStage.setTitle("");
    Group root = new Group();
    Scene scene = new Scene(root, 400, 300, Color.WHITE);

    GridPane gridpane = new GridPane();
    gridpane.setGridLinesVisible(true);
    ColumnConstraints col1 = new ColumnConstraints();
    col1.setPercentWidth(25);
    ColumnConstraints col2 = new ColumnConstraints();
    col2.setPercentWidth(50);
    ColumnConstraints col3 = new ColumnConstraints();
    col3.setPercentWidth(25);
    gridpane.getColumnConstraints().addAll(col1,col2,col3);


    gridpane.add(new Label("2"), 2, 0);
    gridpane.add(new Label("1"), 1, 0);
    gridpane.add(new Label("0"), 0, 0);

    root.getChildren().add(new BorderPane(gridpane));
    primaryStage.setScene(scene);

    primaryStage.show();
  }

}