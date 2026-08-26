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
 * Basic smart card with which communication has been established after a selection process and
 * which is ready to receive APDUs, to be implemented and possibly extended by a card extension.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_SmartCard">SmartCard</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public interface SmartCard {

  /**
   * Returns the card's power-on data, i.e. the data retrieved by the reader when the card is
   * inserted, as a string that may be either a hexadecimal string or any other relevant
   * representation.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_SmartCard_getPowerOnData">SmartCard.getPowerOnData</a>
   * for the normative contract.
   *
   * @return Null if no power-on data is available.
   * @since 1.0.0
   */
  String getPowerOnData();

  /**
   * Returns whether this smart card is still active on its logical channel, i.e. whether it has not
   * yet been released by the reader.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_SmartCard_isActive">SmartCard.isActive</a>
   * for the normative contract.
   *
   * @return <b>true</b> if the smart card is active else <b>false</b>.
   * @since 3.0.0
   */
  boolean isActive();
}
