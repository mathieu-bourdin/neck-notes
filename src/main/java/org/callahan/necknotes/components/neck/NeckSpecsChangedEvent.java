package org.callahan.necknotes.components.neck;

import org.callahan.necknotes.components.utils.CustomEvent;
import org.callahan.necknotes.core.NeckSpecifications;

public class NeckSpecsChangedEvent extends CustomEvent {

  private final NeckSpecifications specifications;
  private final FretBoardContext context;

  public NeckSpecsChangedEvent(NeckSpecifications specs) {
    specifications = specs;
    context = new FretBoardContext(specs);
  }

  public NeckSpecifications getSpecifications() {
    return specifications;
  }

  public FretBoardContext getUpdatedContext() {
    return context;
  }
}
