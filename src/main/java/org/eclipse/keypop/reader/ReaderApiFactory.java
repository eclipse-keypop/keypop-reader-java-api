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
package org.eclipse.keypop.reader;

import org.eclipse.keypop.reader.selection.BasicCardSelector;
import org.eclipse.keypop.reader.selection.CardSelectionManager;
import org.eclipse.keypop.reader.selection.IsoCardSelector;

/**
 * Factory used by the application to obtain instances of the public types provided by the API.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_ReaderApiFactory">ReaderApiFactory</a>
 * for the normative contract.
 *
 * @since 2.0.0
 */
public interface ReaderApiFactory {

  /**
   * Returns the {@link CardReaderProvider} giving access to the readers available in the execution
   * environment.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_ReaderApiFactory_getCardReaderProvider">ReaderApiFactory.getCardReaderProvider</a>
   * for the normative contract.
   *
   * @return A non-null reference.
   * @since 3.0.0
   */
  CardReaderProvider getCardReaderProvider();

  /**
   * Returns a new instance of {@link CardDetectionSettings}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_ReaderApiFactory_createCardDetectionSettings">ReaderApiFactory.createCardDetectionSettings</a>
   * for the normative contract.
   *
   * @return A new instance of {@link CardDetectionSettings}.
   * @since 3.0.0
   */
  CardDetectionSettings createCardDetectionSettings();

  /**
   * Returns a new instance of {@link CardSelectionManager}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_ReaderApiFactory_createCardSelectionManager">ReaderApiFactory.createCardSelectionManager</a>
   * for the normative contract.
   *
   * @return A new instance of {@link CardSelectionManager}.
   * @since 2.0.0
   */
  CardSelectionManager createCardSelectionManager();

  /**
   * Returns a new instance of {@link BasicCardSelector}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_ReaderApiFactory_createBasicCardSelector">ReaderApiFactory.createBasicCardSelector</a>
   * for the normative contract.
   *
   * @return A new instance of {@link BasicCardSelector}.
   * @since 2.0.0
   */
  BasicCardSelector createBasicCardSelector();

  /**
   * Returns a new instance of {@link IsoCardSelector}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_ReaderApiFactory_createIsoCardSelector">ReaderApiFactory.createIsoCardSelector</a>
   * for the normative contract.
   *
   * @return A new instance of {@link IsoCardSelector}.
   * @since 2.0.0
   */
  IsoCardSelector createIsoCardSelector();
}
