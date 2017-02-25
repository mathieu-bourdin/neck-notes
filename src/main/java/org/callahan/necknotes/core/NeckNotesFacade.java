package org.callahan.necknotes.core;

import org.callahan.necknotes.core.necks.FiveStringsBanjo;
import org.callahan.necknotes.core.necks.GuitarStandard;
import org.callahan.necknotes.core.necks.TestInstrument;
import org.callahan.necknotes.core.necks.Ukulele;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class NeckNotesFacade {

  private static TonesSelection selection = new TonesSelection();
  private static NeckSpecifications currentLayout = new GuitarStandard();

  public static void selectTone(Tone t) {
    selection.selectTone(t);
  }

  public static void deselectTone(Tone t) {
    selection.deselectTone(t);
  }

  public static List<Tone> getTonesOrder() {
    return Arrays.asList(Tone.CHROMATIC);
  }

  public static boolean isSelected(Tone t) {
    return selection.isSelected(t);
  }

  public static NeckSpecifications getNeckSpecifications() {
    return currentLayout;
  }

  public static Set<Tone> getSelectedTones() {
    return selection.getSelectedTones();
  }
}
