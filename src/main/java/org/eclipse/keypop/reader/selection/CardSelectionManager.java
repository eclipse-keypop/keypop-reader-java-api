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

import org.eclipse.keypop.reader.CardCommunicationException;
import org.eclipse.keypop.reader.CardReader;
import org.eclipse.keypop.reader.CardReaderEvent;
import org.eclipse.keypop.reader.InvalidCardResponseException;
import org.eclipse.keypop.reader.ObservableCardReader;
import org.eclipse.keypop.reader.ReaderCommunicationException;
import org.eclipse.keypop.reader.selection.spi.CardSelectionExtension;

/**
 * Service responsible for preparing and executing card selection scenarios, obtained via the method
 * {@link org.eclipse.keypop.reader.ReaderApiFactory#createCardSelectionManager()}.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_CardSelectionManager">CardSelectionManager</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public interface CardSelectionManager {

  /**
   * Appends a card selection case to the card selection scenario and returns the index giving its
   * position in the scenario, to be used to retrieve the corresponding result in the {@link
   * CardSelectionResult} object.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardSelectionManager_prepareSelection">CardSelectionManager.prepareSelection</a>
   * for the normative contract.
   *
   * @param cardSelector The card selector containing the filters to be used to select the card.
   * @param cardSelectionExtension The card selection extension to be used to parse the card
   *     selection response.
   * @return A non-negative int.
   * @throws IllegalArgumentException If the provided card selector or card selection extension is
   *     null.
   * @since 2.0.0
   */
  int prepareSelection(CardSelector<?> cardSelector, CardSelectionExtension cardSelectionExtension);

  /**
   * Exports the content of the current prepared card selection scenario in string format, so that
   * it can be imported into the same or another card selection manager via the method {@link
   * #importCardSelectionScenario(String)}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardSelectionManager_exportCardSelectionScenario">CardSelectionManager.exportCardSelectionScenario</a>
   * for the normative contract.
   *
   * @return A non-empty string.
   * @see #importCardSelectionScenario(String)
   * @since 1.1.0
   */
  String exportCardSelectionScenario();

  /**
   * Imports a card selection scenario previously exported in string format via the method {@link
   * #exportCardSelectionScenario()}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardSelectionManager_importCardSelectionScenario">CardSelectionManager.importCardSelectionScenario</a>
   * for the normative contract.
   *
   * @param cardSelectionScenario The string containing the exported card selection scenario.
   * @return The index of the last imported selection in the card selection scenario.
   * @throws IllegalArgumentException If the string is null or malformed.
   * @see #exportCardSelectionScenario()
   * @since 1.1.0
   */
  int importCardSelectionScenario(String cardSelectionScenario);

  /**
   * Explicitly executes a previously prepared card selection scenario with the provided execution
   * policy and returns the card selection result.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardSelectionManager_processCardSelectionScenario">CardSelectionManager.processCardSelectionScenario</a>
   * for the normative contract.
   *
   * @param reader The reader to communicate with the card.
   * @param selectionExecutionPolicy The policy governing the iteration over the selection cases.
   * @return A non-null reference.
   * @throws IllegalArgumentException If one of the provided parameters is null.
   * @throws ReaderCommunicationException If the communication with the reader has failed.
   * @throws CardCommunicationException If communication with the card has failed.
   * @throws InvalidCardResponseException If the card returned invalid data during the selection
   *     process, or if the status word check is enabled in the card request and the card has
   *     returned an unexpected code.
   * @since 3.0.0
   */
  CardSelectionResult processCardSelectionScenario(
      CardReader reader, SelectionExecutionPolicy selectionExecutionPolicy);

  /**
   * Explicitly executes a previously prepared card selection scenario in multi-channel mode with
   * the provided channel policy and returns the card selection result.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardSelectionManager_processMultichannelCardSelectionScenario">CardSelectionManager.processMultichannelCardSelectionScenario</a>
   * for the normative contract.
   *
   * @param reader The reader to communicate with the card.
   * @param channelSelectionPolicy The policy governing the channels on which selections are placed.
   * @return A non-null reference.
   * @throws IllegalArgumentException If one of the provided parameters is null.
   * @throws ReaderCommunicationException If the communication with the reader has failed.
   * @throws CardCommunicationException If communication with the card has failed.
   * @throws InvalidCardResponseException If the card does not support multi-channel or returned
   *     invalid data.
   * @since 3.0.0
   */
  CardSelectionResult processMultichannelCardSelectionScenario(
      CardReader reader, ChannelSelectionPolicy channelSelectionPolicy);

  /**
   * Schedules the execution of the prepared card selection scenario as soon as a card is presented
   * to the provided {@link ObservableCardReader}, with the provided notification and execution
   * policies.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardSelectionManager_scheduleCardSelectionScenario">CardSelectionManager.scheduleCardSelectionScenario</a>
   * for the normative contract.
   *
   * @param observableCardReader The reader with which the card communication is carried out.
   * @param cardPresenceNotificationPolicy The card presence notification policy to use when a card
   *     is detected.
   * @param selectionExecutionPolicy The policy governing the iteration over the selection cases.
   * @throws IllegalArgumentException If one of the provided parameters is null.
   * @since 3.0.0
   */
  void scheduleCardSelectionScenario(
      ObservableCardReader observableCardReader,
      CardPresenceNotificationPolicy cardPresenceNotificationPolicy,
      SelectionExecutionPolicy selectionExecutionPolicy);

  /**
   * Analyzes the responses provided by a {@link CardReaderEvent} following the insertion of a card
   * and the execution of the scheduled card selection scenario.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardSelectionManager_parseScheduledCardSelectionsResponse">CardSelectionManager.parseScheduledCardSelectionsResponse</a>
   * for the normative contract.
   *
   * @param scheduledCardSelectionsResponse The card selection scenario execution response.
   * @return A non-null reference.
   * @throws IllegalArgumentException If the provided card selection response is null.
   * @throws InvalidCardResponseException If the data returned by the card could not be interpreted.
   * @since 1.0.0
   */
  CardSelectionResult parseScheduledCardSelectionsResponse(
      ScheduledCardSelectionsResponse scheduledCardSelectionsResponse);

  /**
   * Exports the content of the previously processed card selection scenario in string format, so
   * that it can be imported into the same or another card selection manager via the method {@link
   * #importProcessedCardSelectionScenario(String)}.
   *
   * <p>Prerequisite: the card selection scenario must first have been processed via the {@link
   * #processCardSelectionScenario(CardReader, SelectionExecutionPolicy)}, {@link
   * #processMultichannelCardSelectionScenario(CardReader, ChannelSelectionPolicy)} or {@link
   * #parseScheduledCardSelectionsResponse(ScheduledCardSelectionsResponse)} method.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardSelectionManager_exportProcessedCardSelectionScenario">CardSelectionManager.exportProcessedCardSelectionScenario</a>
   * for the normative contract.
   *
   * @return A non-empty string.
   * @throws IllegalStateException If the card selection scenario has not yet been processed or has
   *     failed.
   * @see #importProcessedCardSelectionScenario(String)
   * @since 1.3.0
   */
  String exportProcessedCardSelectionScenario();

  /**
   * Imports a previously exported processed card selection scenario in string format and returns
   * the card selection result.
   *
   * <p>Prerequisites:
   *
   * <ul>
   *   <li>the string must have been exported from a card selection manager via the method {@link
   *       #exportProcessedCardSelectionScenario()},
   *   <li>the local environment must have the card extensions involved in the card selection
   *       scenario,
   *   <li>the current manager must first be configured with the same card selection scenario as the
   *       manager that was used to export the processed card selection scenario.
   * </ul>
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardSelectionManager_importProcessedCardSelectionScenario">CardSelectionManager.importProcessedCardSelectionScenario</a>
   * for the normative contract.
   *
   * @param processedCardSelectionScenario The string containing the exported processed card
   *     selection scenario.
   * @return A non-null reference.
   * @throws IllegalArgumentException If the string is null, malformed or contains more card
   *     selection cases than the current card selection scenario.
   * @throws InvalidCardResponseException If the data returned by the card could not be interpreted.
   * @see #exportProcessedCardSelectionScenario()
   * @since 1.3.0
   */
  CardSelectionResult importProcessedCardSelectionScenario(String processedCardSelectionScenario);

  /**
   * Options applied when a card is detected, used to decide which cards trigger event handler
   * notifications.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_CardPresenceNotificationPolicy">CardPresenceNotificationPolicy</a>
   * for the normative contract.
   *
   * @since 3.0.0
   */
  enum CardPresenceNotificationPolicy {

    /**
     * All cards presented to the reader are notified, regardless of the result of the selection.
     *
     * @since 3.0.0
     */
    ALWAYS,

    /**
     * Only the cards that have been successfully selected are notified, the others are ignored.
     *
     * @since 3.0.0
     */
    MATCHED_ONLY
  }

  /**
   * Policy governing the iteration over the selection cases of a card selection scenario.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_SelectionExecutionPolicy">SelectionExecutionPolicy</a>
   * for the normative contract.
   *
   * @since 3.0.0
   */
  enum SelectionExecutionPolicy {

    /**
     * The manager stops at the first successful selection case.
     *
     * @since 3.0.0
     */
    STOP_ON_FIRST_MATCH,

    /**
     * The manager processes every selection case regardless of intermediate successes.
     *
     * @since 3.0.0
     */
    PROCESS_ALL
  }

  /**
   * Policy governing the use of the basic channel in a multi-channel card selection scenario.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_ChannelSelectionPolicy">ChannelSelectionPolicy</a>
   * for the normative contract.
   *
   * @since 3.0.0
   */
  enum ChannelSelectionPolicy {

    /**
     * The basic channel may host selection cases in addition to the additional logical channels.
     *
     * @since 3.0.0
     */
    ALLOW_BASIC_CHANNEL,

    /**
     * Selection cases are placed only on additional logical channels, the basic channel is not
     * used.
     *
     * @since 3.0.0
     */
    LOGICAL_CHANNEL_ONLY
  }
}
