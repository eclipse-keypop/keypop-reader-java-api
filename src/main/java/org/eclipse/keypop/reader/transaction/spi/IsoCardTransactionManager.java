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

import org.eclipse.keypop.reader.InvalidCardResponseException;

/**
 * Transaction manager of an ISO/IEC 7816-4 card, for which the multi-channel capability is
 * optional.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_IsoCardTransactionManager">IsoCardTransactionManager</a>
 * for the normative contract.
 *
 * @since 3.0.0
 */
public interface IsoCardTransactionManager extends CardTransactionManager {

  /**
   * Returns a view of this manager granting access to the multi-channel operations.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_IsoCardTransactionManager_asMultichannelCardTransactionManager">IsoCardTransactionManager.asMultichannelCardTransactionManager</a>
   * for the normative contract.
   *
   * @return A non-null reference.
   * @throws InvalidCardResponseException If the card does not support multi-channel.
   * @since 3.0.0
   */
  MultichannelCardTransactionManager asMultichannelCardTransactionManager();
}
