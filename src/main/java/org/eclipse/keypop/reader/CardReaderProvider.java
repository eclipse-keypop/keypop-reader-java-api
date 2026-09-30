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
package org.eclipse.keypop.reader;

import java.util.Set;

/**
 * Read-only view over the card readers available in the execution environment.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_CardReaderProvider">CardReaderProvider</a>
 * for the normative contract.
 *
 * @since 3.0.0
 */
public interface CardReaderProvider {

  /**
   * Returns the names of all readers currently registered in the execution environment.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardReaderProvider_getReaderNames">CardReaderProvider.getReaderNames</a>
   * for the normative contract.
   *
   * @return A non-null but possibly empty set.
   * @since 3.0.0
   */
  Set<String> getReaderNames();

  /**
   * Returns all readers currently registered in the execution environment.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardReaderProvider_getReaders">CardReaderProvider.getReaders</a>
   * for the normative contract.
   *
   * @return A non-null but possibly empty set.
   * @since 3.0.0
   */
  Set<CardReader> getReaders();

  /**
   * Returns the reader whose name exactly matches the provided string.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardReaderProvider_getReader">CardReaderProvider.getReader</a>
   * for the normative contract.
   *
   * @param readerName The exact name of the reader to retrieve.
   * @return Null if no such reader is registered.
   * @throws IllegalArgumentException If the provided name is null.
   * @since 3.0.0
   */
  CardReader getReader(String readerName);

  /**
   * Returns the first reader whose name matches the provided regular expression.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardReaderProvider_findReader">CardReaderProvider.findReader</a>
   * for the normative contract.
   *
   * @param readerNameRegex The regular expression matched against the reader names.
   * @return Null if no reader name matches the expression.
   * @throws IllegalArgumentException If the provided regular expression is null or invalid.
   * @since 3.0.0
   */
  CardReader findReader(String readerNameRegex);
}
