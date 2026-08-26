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
package org.eclipse.keypop.reader;

import org.eclipse.keypop.reader.selection.CardSelectionManager;
import org.eclipse.keypop.reader.selection.ScheduledCardSelectionsResponse;

/**
 * Data container describing a change of state observed by a card reader.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_CardReaderEvent">CardReaderEvent</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public interface CardReaderEvent {

  /**
   * Returns the name of the reader that generated the event.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardReaderEvent_getReaderName">CardReaderEvent.getReaderName</a>
   * for the normative contract.
   *
   * @return A non-empty string.
   * @since 1.0.0
   */
  String getReaderName();

  /**
   * Returns the type of the event.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardReaderEvent_getType">CardReaderEvent.getType</a>
   * for the normative contract.
   *
   * @return A non-null value.
   * @since 1.0.0
   */
  Type getType();

  /**
   * Returns the response of the selection scenario scheduled on the reader, to be interpreted with
   * {@link
   * CardSelectionManager#parseScheduledCardSelectionsResponse(ScheduledCardSelectionsResponse)}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardReaderEvent_getScheduledCardSelectionsResponse">CardReaderEvent.getScheduledCardSelectionsResponse</a>
   * for the normative contract.
   *
   * @return Null if no selection scenario has been scheduled.
   * @since 1.0.0
   */
  ScheduledCardSelectionsResponse getScheduledCardSelectionsResponse();

  /**
   * Possible card reader events.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_Type">Type</a>
   * for the normative contract.
   *
   * @since 1.0.0
   */
  enum Type {

    /**
     * A card has been inserted, with or without a specific selection.
     *
     * @since 1.0.0
     */
    CARD_INSERTED,

    /**
     * A card has been inserted that matches the selection criteria.
     *
     * @since 1.0.0
     */
    CARD_MATCHED,

    /**
     * The card has been removed from the reader.
     *
     * @since 1.0.0
     */
    CARD_REMOVED,

    /**
     * The reader has been unregistered and is no longer usable.
     *
     * @since 3.0.0
     */
    READER_UNREGISTERED
  }
}
