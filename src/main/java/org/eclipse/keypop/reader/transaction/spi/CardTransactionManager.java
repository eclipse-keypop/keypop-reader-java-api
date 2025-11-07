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

import org.eclipse.keypop.reader.ChannelControl;
import org.eclipse.keypop.reader.selection.spi.SmartCard;

/**
 * Contains operations common to all card transactions.
 *
 * <p>To exchange data with the card, it is first necessary to prepare the commands to be
 * transmitted to the card and then to process the prepared commands.
 *
 * <p>The card commands preparation step makes it possible to group commands together to minimize
 * network data exchanges (especially useful in a distributed architecture).
 *
 * <p>The {@link SmartCard} object registered with the manager is updated during the transaction
 * after each data exchange with the card.
 *
 * @param <T> The type of the lowest level child object.
 * @since 2.1.0
 */
public interface CardTransactionManager<T extends CardTransactionManager<T>> {

  /**
   * Processes all previously prepared commands and closes the physical channel if requested.
   *
   * <p>All APDUs corresponding to the prepared commands are sent to the card, their responses are
   * retrieved and used to update the {@link SmartCard} associated with the transaction.
   *
   * <p>For write commands, the {@link SmartCard} is updated only when the command is successful.
   *
   * <p>The process is interrupted at the first failed command.
   *
   * @param channelControl Policy for managing the physical channel after executing commands to the
   *     card.
   * @return The current instance.
   * @since 2.1.0
   */
  T processCommands(ChannelControl channelControl);
}
