/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This file is part of Eclipse Keypop.
 *
 * Eclipse Keypop is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License. A copy of the License is located at
 *
 * http://opensource.org/licenses/MIT
 ************************************************************************************** */
package org.eclipse.keypop.reader.selection;

import java.util.Map;
import org.eclipse.keypop.reader.selection.spi.CardSelectionExtension;
import org.eclipse.keypop.reader.selection.spi.SmartCard;

/**
 * Result of a selection process.
 *
 * <p>Each selection case prepared with the card selection manager is associated with an index
 * corresponding to its rank in the order of preparation.<br>
 * The same index is used here to find out which selection cases were successful.<br>
 * However, only one case will correspond to the selected card state. The getters of this interface
 * allow to make use of these results according to the configurations and the needs of the
 * application.
 *
 * @since 1.0.0
 */
public interface CardSelectionResult {

  /**
   * Gets all {@link SmartCard} corresponding to all successful selection cases in a map for which
   * the key is the selection index provided by the {@link
   * CardSelectionManager#prepareSelection(CardSelector, CardSelectionExtension)} method.
   *
   * @return A non-null but possibly empty map.
   * @since 1.0.0
   */
  Map<Integer, SmartCard> getSmartCards();

  /**
   * Gets the active matching card. I.e. the card that has been selected.
   *
   * @return Null if there is no active card.
   * @since 1.0.0
   */
  SmartCard getActiveSmartCard();

  /**
   * Gets the index of the active selection if any.
   *
   * @return A positive value if there is an active selection, -1 if there is no active selection.
   * @since 1.0.0
   */
  int getActiveSelectionIndex();
}
