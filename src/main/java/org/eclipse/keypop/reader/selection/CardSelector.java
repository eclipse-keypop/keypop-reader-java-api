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

import org.eclipse.keypop.definitions.CardType;

/**
 * Base contract of all card selectors, defining the filters used to restrict the selection process
 * to a subset of cards.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_CardSelector">CardSelector</a>
 * for the normative contract.
 *
 * @param <T> The type of the lowest level child object.
 * @since 2.0.0
 */
public interface CardSelector<T extends CardSelector<T>> {

  /**
   * Restricts the selection process to cards whose detected type matches the provided value.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardSelector_filterByCardType">CardSelector.filterByCardType</a>
   * for the normative contract.
   *
   * @param cardType The card type to use as filter.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided card type is null.
   * @since 3.0.0
   */
  T filterByCardType(CardType cardType);

  /**
   * Restricts the selection process to cards whose power-on data provided by the reader matches a
   * specific regular expression.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardSelector_filterByPowerOnData">CardSelector.filterByPowerOnData</a>
   * for the normative contract.
   *
   * @param powerOnDataRegex The regular expression to use as filter.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided regular expression is null, empty or invalid.
   * @since 2.0.0
   */
  T filterByPowerOnData(String powerOnDataRegex);
}
