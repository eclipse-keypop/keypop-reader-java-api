/* **************************************************************************************
 * Copyright (c) 2025 Calypso Networks Association https://calypsonet.org/
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
import org.eclipse.keypop.reader.selection.spi.SmartCard;

/**
 * Root contract common to every card transaction manager exposed by a card extension, the {@link
 * SmartCard} registered with the manager being updated after each data exchange with the card.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_CardTransactionManager">CardTransactionManager</a>
 * for the normative contract.
 *
 * @since 2.1.0
 */
public interface CardTransactionManager {

  /**
   * Processes all previously prepared commands, the underlying logical channel being left open.
   *
   * <p>All APDUs corresponding to the prepared commands are sent to the card, their responses are
   * retrieved and used to update the {@link SmartCard} associated with the transaction. For write
   * commands, the {@link SmartCard} is updated only when the command is successful. The process is
   * interrupted at the first failed command.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardTransactionManager_processCommands">CardTransactionManager.processCommands</a>
   * for the normative contract.
   *
   * @throws ReaderCommunicationException If a communication error with the card reader occurs.
   * @throws CardCommunicationException If a communication error with the card occurs.
   * @throws InvalidCardResponseException If a command returns an unexpected status.
   * @since 3.0.0
   */
  void processCommands();
}
