package org.callahan.necknotes.components.neck;

import org.callahan.necknotes.controllers.Controller;
import org.callahan.necknotes.core.NeckSpecifications;

public class NeckSpecificationsController
  extends Controller<NeckSpecsChangedEvent> {

  public void changeNeckSpecs(NeckSpecifications specs) {
    notifyListeners(new NeckSpecsChangedEvent(specs));
  }

}
