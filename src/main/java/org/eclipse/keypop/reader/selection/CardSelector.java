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

/**
 * Common filters used to restrict the selection process to certain cards.
 *
 * <p>These filters are all optional but can also be combined.
 *
 * <p>If no filtering is specified, any card that responds when inserted in the reader will be
 * considered selected.
 *
 * <p>Conversely, if one or more filters have been defined, the card will not be selected if one of
 * them rejects the card.
 *
 * @param <T> The type of the lowest level child object.
 * @since 2.0.0
 */
public interface CardSelector<T extends CardSelector<T>> {

  /**
   * Restricts the selection process to cards communicating with the reader according to a specific
   * protocol, corresponding to the underlying technology: ISO14443-A, ISO14443-B or any other
   * proprietary or standardized communication technology.
   *
   * <p>The protocol is identified by its <b>logical name</b>.
   *
   * <p><b>Prerequisites</b>: the reader must be of type {@link
   * org.eclipse.keypop.reader.ConfigurableCardReader} and the targeted card protocol(s) must be
   * activated via the {@link
   * org.eclipse.keypop.reader.ConfigurableCardReader#activateProtocol(String, String)} method and
   * associated with the logical name used as a filter.
   *
   * @param logicalProtocolName The logical name of the protocol to use as filter.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided logical protocol name is null or empty.
   * @since 2.0.0
   */
  T filterByCardProtocol(String logicalProtocolName);

  /**
   * Restricts the selection process to cards whose power-on data provided by the reader matches a
   * specific regular expression.
   *
   * @param powerOnDataRegex The regular expression to use as filter.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided regular expression is null, empty or invalid.
   * @since 2.0.0
   */
  T filterByPowerOnData(String powerOnDataRegex);
}
