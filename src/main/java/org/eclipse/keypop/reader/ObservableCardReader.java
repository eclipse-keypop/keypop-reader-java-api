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

import org.eclipse.keypop.reader.spi.CardReaderEventHandler;

/**
 * Card reader able to observe the insertion and the removal of cards.
 *
 * @since 1.0.0
 */
public interface ObservableCardReader extends CardReader {

  /**
   * Starts the card detection with the provided settings and registers the handler that will
   * receive the resulting reader events and observation errors.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_ObservableCardReader_startCardDetection">ObservableCardReader.startCardDetection</a>
   * for the normative contract.
   *
   * @param settings The detection configuration.
   * @param eventHandler The application-side handler receiving the reader events and errors.
   * @throws IllegalArgumentException If one of the provided parameters is null.
   * @since 3.0.0
   */
  void startCardDetection(CardDetectionSettings settings, CardReaderEventHandler eventHandler);

  /**
   * Stops the card detection.
   *
   * @since 1.0.0
   */
  void stopCardDetection();

  /**
   * Notifies the reader that the business processing of the current card has been completed, so
   * that it can deselect the card, release the associated smart cards and wait for the card
   * removal.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_ObservableCardReader_endCardProcessing">ObservableCardReader.endCardProcessing</a>
   * for the normative contract.
   *
   * @since 3.0.0
   */
  void endCardProcessing();
}
