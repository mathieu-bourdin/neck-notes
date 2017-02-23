package org.callahan.necknotes.core;

import org.callahan.necknotes.core.necks.FiveStringsBanjo;
import org.callahan.necknotes.core.necks.GuitarStandard;
import org.callahan.necknotes.core.necks.TestInstrument;
import org.callahan.necknotes.core.necks.Ukulele;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class NeckNotesFacade {

  private TonesSelection selection;
  private NeckSpecifications currentLayout;

  public NeckNotesFacade(NeckSpecifications layout) {
    currentLayout = layout;
    selection = new TonesSelection();
  }

  public void selectTone(Tone t) {
    selection.selectTone(t);
  }

  public void deselectTone(Tone t) {
    selection.deselectTone(t);
  }

  public List<Tone> getTonesOrder() {
    return Arrays.asList(Tone.CHROMATIC);
  }

  public boolean isSelected(Tone t) {
    return selection.isSelected(t);
  }

  public NeckSpecifications getNeckSpecifications() {
    return currentLayout;
  }

  public Set<Tone> getSelectedTones() {
    return selection.getSelectedTones();
  }
}
