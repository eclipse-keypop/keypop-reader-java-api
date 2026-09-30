/* **************************************************************************************
 * Copyright (c) 2026 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keypop.reader.spi;

import org.eclipse.keypop.reader.CardReaderEvent;

/**
 * Handler to be implemented by the application to receive the events and the observation errors
 * produced by an observable card reader.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_CardReaderEventHandler">CardReaderEventHandler</a>
 * for the normative contract.
 *
 * @since 3.0.0
 */
public interface CardReaderEventHandler {

  /**
   * Invoked when a reader event occurs.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardReaderEventHandler_onReaderEvent">CardReaderEventHandler.onReaderEvent</a>
   * for the normative contract.
   *
   * @param cardReaderEvent The event data.
   * @since 3.0.0
   */
  void onReaderEvent(CardReaderEvent cardReaderEvent);

  /**
   * Invoked when a fatal error occurs on the observed reader, the observation process being
   * considered stopped once this method returns.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardReaderEventHandler_onReaderError">CardReaderEventHandler.onReaderError</a>
   * for the normative contract.
   *
   * @param context The context describing the operation that failed.
   * @param readerName The name of the reader on which the error occurred.
   * @param e The original exception.
   * @since 3.0.0
   */
  void onReaderError(String context, String readerName, Throwable e);
}
