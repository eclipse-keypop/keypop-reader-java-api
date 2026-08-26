/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keypop.reader.selection;

import java.util.List;
import java.util.Map;
import org.eclipse.keypop.definitions.CardType;
import org.eclipse.keypop.reader.selection.spi.CardSelectionExtension;
import org.eclipse.keypop.reader.selection.spi.SmartCard;

/**
 * Result of a card selection process, each selection case being identified by the index returned by
 * {@link CardSelectionManager#prepareSelection(CardSelector, CardSelectionExtension)}.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_CardSelectionResult">CardSelectionResult</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public interface CardSelectionResult {

  /**
   * Returns the type of the detected card.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardSelectionResult_getCardType">CardSelectionResult.getCardType</a>
   * for the normative contract.
   *
   * @return A non-null value, {@link CardType#UNKNOWN} if the card type could not be identified.
   * @since 3.0.0
   */
  CardType getCardType();

  /**
   * Returns all the {@link SmartCard} corresponding to the successful selection cases, indexed by
   * the selection index.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardSelectionResult_getSmartCards">CardSelectionResult.getSmartCards</a>
   * for the normative contract.
   *
   * @return A non-null but possibly empty map.
   * @since 1.0.0
   */
  Map<Integer, SmartCard> getSmartCards();

  /**
   * Returns the active matching card, i.e. the card that has been selected, the one placed on the
   * basic channel in multi-channel mode.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardSelectionResult_getActiveSmartCard">CardSelectionResult.getActiveSmartCard</a>
   * for the normative contract.
   *
   * @return Null if there is no active card.
   * @since 1.0.0
   */
  SmartCard getActiveSmartCard();

  /**
   * Returns the index of the active selection if any.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardSelectionResult_getActiveSelectionIndex">CardSelectionResult.getActiveSelectionIndex</a>
   * for the normative contract.
   *
   * @return A non-negative value if there is an active selection, -1 otherwise.
   * @since 1.0.0
   */
  int getActiveSelectionIndex();

  /**
   * Returns the indexes of all the active selections, one per channel in multi-channel mode.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardSelectionResult_getActiveSelectionIndexes">CardSelectionResult.getActiveSelectionIndexes</a>
   * for the normative contract.
   *
   * @return A non-null but possibly empty list of non-negative values.
   * @since 3.0.0
   */
  List<Integer> getActiveSelectionIndexes();
}
