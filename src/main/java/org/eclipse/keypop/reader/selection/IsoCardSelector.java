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

import org.eclipse.keypop.reader.ReaderApiFactory;

/**
 * ISO 7816-4 card selector, obtained via the method {@link
 * ReaderApiFactory#createIsoCardSelector()}.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_IsoCardSelector">IsoCardSelector</a>
 * for the normative contract.
 *
 * @since 2.0.0
 */
public interface IsoCardSelector extends CardSelector<IsoCardSelector> {

  /**
   * Selects a card application DF whose name starts with the provided AID, as defined by ISO7816-4
   * chapter 4.2.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_IsoCardSelector_filterByDfName_byteArray">IsoCardSelector.filterByDfName</a>
   * for the normative contract.
   *
   * @param aid The AID as a byte array containing 5 to 16 bytes.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided array is null or out of range.
   * @since 2.0.0
   */
  IsoCardSelector filterByDfName(byte[] aid);

  /**
   * Selects a card application DF whose name starts with the provided AID, as defined by ISO7816-4
   * chapter 4.2.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_IsoCardSelector_filterByDfName_string">IsoCardSelector.filterByDfName</a>
   * for the normative contract.
   *
   * @param aid The AID as a hexadecimal string of 5 to 16 bytes.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided string is null, invalid or out of range.
   * @since 2.0.0
   */
  IsoCardSelector filterByDfName(String aid);

  /**
   * Sets the file occurrence mode (see ISO7816-4), the default value being {@link
   * FileOccurrence#FIRST}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_IsoCardSelector_setFileOccurrence">IsoCardSelector.setFileOccurrence</a>
   * for the normative contract.
   *
   * @param fileOccurrence The navigation option to apply.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided file occurrence is null.
   * @since 2.0.0
   */
  IsoCardSelector setFileOccurrence(FileOccurrence fileOccurrence);

  /**
   * Sets the file control mode (see ISO7816-4), the default value being {@link
   * FileControlInformation#FCI}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_IsoCardSelector_setFileControlInformation">IsoCardSelector.setFileControlInformation</a>
   * for the normative contract.
   *
   * @param fileControlInformation The file control mode to apply.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided file control information is null.
   * @since 2.0.0
   */
  IsoCardSelector setFileControlInformation(FileControlInformation fileControlInformation);

  /**
   * Navigation options through the different applications contained in the card according to the
   * ISO7816-4 standard.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_FileOccurrence">FileOccurrence</a>
   * for the normative contract.
   *
   * @since 2.0.0
   */
  enum FileOccurrence {

    /**
     * First occurrence.
     *
     * @since 2.0.0
     */
    FIRST,

    /**
     * Last occurrence.
     *
     * @since 2.0.0
     */
    LAST,

    /**
     * Next occurrence.
     *
     * @since 2.0.0
     */
    NEXT,

    /**
     * Previous occurrence.
     *
     * @since 2.0.0
     */
    PREVIOUS
  }

  /**
   * Types of templates available in return for the Select Application command, according to the
   * ISO7816-4 standard.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_FileControlInformation">FileControlInformation</a>
   * for the normative contract.
   *
   * @since 2.0.0
   */
  enum FileControlInformation {

    /**
     * File control information.
     *
     * @since 2.0.0
     */
    FCI,

    /**
     * File control parameters.
     *
     * @since 2.0.0
     */
    FCP,

    /**
     * File management data.
     *
     * @since 2.0.0
     */
    FMD,

    /**
     * No response expected.
     *
     * @since 2.0.0
     */
    NO_RESPONSE
  }
}
