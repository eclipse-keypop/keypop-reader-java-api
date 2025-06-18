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
 * Card event data container indicating a change of state.
 *
 * <p>Contains the event origin (reader name), the event type and possibly the card selection
 * response (when available).
 *
 * @since 1.0.0
 */
public interface CardReaderEvent {

  /**
   * Returns the name of the reader that generated the event.
   *
   * @return A non-empty string.
   * @since 1.0.0
   */
  String getReaderName();

  /**
   * Returns the card reader event type.
   *
   * @return A non-null value.
   * @since 1.0.0
   */
  Type getType();

  /**
   * Returns the card selection responses when it is available and null in all other cases. It may
   * be available when the event type is {@link Type#CARD_INSERTED} and always present when the
   * event type is {@link Type#CARD_MATCHED}.
   *
   * <p>It is necessary to use the method {@link
   * CardSelectionManager#parseScheduledCardSelectionsResponse(ScheduledCardSelectionsResponse)} to
   * analyze the result.
   *
   * @return Null if the event is not carrying a {@link ScheduledCardSelectionsResponse}.
   * @since 1.0.0
   */
  ScheduledCardSelectionsResponse getScheduledCardSelectionsResponse();

  /**
   * Possible card events.
   *
   * @since 1.0.0
   */
  enum Type {

    /**
     * A card has been inserted with or without specific selection.
     *
     * @since 1.0.0
     */
    CARD_INSERTED,

    /**
     * A card has been inserted that matches the selection.
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
     * The reader has become unavailable.
     *
     * @since 1.0.0
     */
    UNAVAILABLE
  }
}
