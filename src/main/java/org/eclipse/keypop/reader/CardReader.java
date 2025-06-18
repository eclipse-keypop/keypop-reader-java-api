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

/**
 * Card reader driving the underlying hardware to manage the card detection.
 *
 * @since 1.0.0
 */
public interface CardReader {

  /**
   * Returns the name of the reader.
   *
   * @return A non-empty string containing the name of the reader.
   * @since 1.0.0
   */
  String getName();

  /**
   * Checks if the card communication mode is contactless.
   *
   * @return <b>true</b> if the communication mode is contactless else <b>false</b>.
   * @since 1.0.0
   */
  boolean isContactless();

  /**
   * Checks if the card is present.
   *
   * @return <b>true</b> if a card is inserted in the reader else <b>false</b>.
   * @throws ReaderCommunicationException If the communication with the reader has failed.
   * @since 1.0.0
   */
  boolean isCardPresent();
}
