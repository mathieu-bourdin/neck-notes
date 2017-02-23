package org.callahan.necknotes.components.tuning;

import org.callahan.necknotes.core.InstrumentString;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TuneStringAction extends AbstractAction {

  private final InstrumentString string;
  private final TuningController controller;

  public TuneStringAction(InstrumentString is, TuningController ctl) {
    super();
    string = is;
    controller = ctl;
    putValue(ACTION_COMMAND_KEY, getCommand());
    putValue(NAME, is.getRootNote().getTone().getLabel());
  }

  public String getCommand() {
    return "tune_string";
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println("Tuning string: " + string);
  }



}
