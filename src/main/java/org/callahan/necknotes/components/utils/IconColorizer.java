package org.callahan.necknotes.components.utils;


import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class IconColorizer {

  public static Image colorize(Image img, Color color) {
    Blend fx = new Blend();
    fx.setMode(BlendMode.SRC_ATOP);
    fx.setBottomInput(new ImageInput(img));
    fx.setTopInput(createTop(img.getWidth(), img.getHeight(), color));
    ImageView view = new ImageView(img);
    view.setEffect(fx);
    Canvas canvas = new Canvas(img.getWidth(), img.getHeight());
    canvas.getGraphicsContext2D().setEffect(fx);
    canvas.getGraphicsContext2D().drawImage(img, 0, 0);
    WritableImage out = new WritableImage((int)img.getWidth(), (int)img.getHeight());
    canvas.snapshot(new SnapshotParameters(), out);
    return out;
  }

  public static Image colorize(String resource, Color color) {
    return colorize(new Image("/img/cog.png"), color);
  }


  private static Effect createTop(double width, double height, Color color) {
    return new ColorInput(0, 0, width, height, color);
  }

}
