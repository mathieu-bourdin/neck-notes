package org.callahan.necknotes.components.neck;

import org.callahan.necknotes.Main;
import org.callahan.necknotes.components.tuning.TuningButtons;

import java.awt.*;

public class Neck extends NeckPartContainer {

  public Neck() {
    super(new GridBagLayout());

    GridBagConstraints c = new GridBagConstraints();

    c.gridx = 1;
    c.gridy = 0;
    c.fill = GridBagConstraints.BOTH;
    c.weightx = 1.0;
    c.weighty = 0.0001;
    add(new FretsNumbering(), c);

    c.gridx = 0;
    c.gridy = 1;
    c.fill = GridBagConstraints.BOTH;
    c.weightx = 0.0;
    c.weighty = 0.0;
    add(new TuningButtons(), c);

    c.gridx = 1;
    c.gridy = 1;
    c.fill = GridBagConstraints.BOTH;
    c.weightx = 1.0;
    c.weighty = 1.0;
    add(new FretBoard(), c);

    neckPropertiesChanged(new FretBoardContext(Main.FACADE.getNeckSpecifications()));

  }

}
