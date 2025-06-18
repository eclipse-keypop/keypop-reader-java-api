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
 * which is ready to receive APDUs.
 *
 * <p>The power-on data that could be collected by the selection process are made available.
 *
 * <p>Must be implemented and possibly extended by a card extension to meet its specific needs.
 *
 * @since 1.0.0
 */
public interface SmartCard {

  /**
   * Gets the card's power-on data.
   *
   * <p>The power-on data is defined as the data retrieved by the reader when the card is inserted.
   *
   * <p>In the case of a contact reader, this is the Answer To Reset data (ATR) defined by ISO7816.
   *
   * <p>In the case of a contactless reader, the reader decides what this data is.<br>
   * Some contactless readers provide a virtual ATR (partially standardized by the PC/SC standard),
   * but other devices can have their own definition, including for example elements from the
   * anti-collision stage of the ISO14443 protocol (ATQA, ATQB, ATS, SAK, etc) or any proprietary
   * definitions.
   *
   * <p>These data being variable from one reader to another, they are defined here in string format
   * which can be either a hexadecimal string or any other relevant information.
   *
   * @return Null if no power-on data is available.
   * @since 1.0.0
   */
  String getPowerOnData();
}
