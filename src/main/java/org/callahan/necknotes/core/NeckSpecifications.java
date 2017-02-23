package org.callahan.necknotes.core;

import java.util.List;

public interface NeckSpecifications {

  /**
   * @return Strings from bottom to top (descending pitch on most instruments).
   */
  List<InstrumentString> getStrings();

  List<FretDecoration> getFretDecorations();

  String getName();

}
