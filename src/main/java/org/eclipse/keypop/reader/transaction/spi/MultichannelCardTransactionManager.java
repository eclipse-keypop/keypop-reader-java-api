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
package org.eclipse.keypop.reader.transaction.spi;

import org.eclipse.keypop.reader.CardCommunicationException;
import org.eclipse.keypop.reader.InvalidCardResponseException;
import org.eclipse.keypop.reader.ReaderCommunicationException;

/**
 * Transaction manager of a card supporting several active logical channels in parallel.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_MultichannelCardTransactionManager">MultichannelCardTransactionManager</a>
 * for the normative contract.
 *
 * @since 3.0.0
 */
public interface MultichannelCardTransactionManager extends CardTransactionManager {

  /**
   * Processes all previously prepared commands and, upon success, closes the underlying logical
   * channel.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_MultichannelCardTransactionManager_processCommandsAndCloseChannel">MultichannelCardTransactionManager.processCommandsAndCloseChannel</a>
   * for the normative contract.
   *
   * @throws ReaderCommunicationException If a communication error with the card reader occurs.
   * @throws CardCommunicationException If a communication error with the card occurs.
   * @throws InvalidCardResponseException If a command returns an unexpected status.
   * @since 3.0.0
   */
  void processCommandsAndCloseChannel();

  /**
   * Closes the underlying logical channel without processing any pending command.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_MultichannelCardTransactionManager_closeChannel">MultichannelCardTransactionManager.closeChannel</a>
   * for the normative contract.
   *
   * @throws ReaderCommunicationException If a communication error with the card reader occurs.
   * @throws CardCommunicationException If a communication error with the card occurs.
   * @since 3.0.0
   */
  void closeChannel();
}
