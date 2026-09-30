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
package org.eclipse.keypop.reader.selection.spi;

/**
 * ISO 7816-4 smart card with which communication has been established after a selection process and
 * which is ready to receive APDUs, to be implemented and possibly extended by an ISO card
 * extension.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_IsoSmartCard">IsoSmartCard</a>
 * for the normative contract.
 *
 * @since 2.0.0
 */
public interface IsoSmartCard extends SmartCard {

  /**
   * Returns the card data received in response to the "Select Application" command, including the
   * status word.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_IsoSmartCard_getSelectApplicationResponse">IsoSmartCard.getSelectApplicationResponse</a>
   * for the normative contract.
   *
   * @return Null if no selection application has been performed.
   * @since 1.0.0
   */
  byte[] getSelectApplicationResponse();

  /**
   * Returns whether this smart card is attached to the basic channel of the underlying ISO 7816-4
   * card, or to an additional logical channel.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_IsoSmartCard_isBasicChannel">IsoSmartCard.isBasicChannel</a>
   * for the normative contract.
   *
   * @return <b>true</b> if attached to the basic channel, <b>false</b> if attached to an additional
   *     logical channel.
   * @since 3.0.0
   */
  boolean isBasicChannel();
}
