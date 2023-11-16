/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.reader;

/**
 * Indicates that the current card protocol is not supported by the reader.
 *
 * @since 1.0.0
 */
public class ReaderProtocolNotSupportedException extends RuntimeException {

  /**
   * @param physicalProtocolName The identification data used to identify the card.
   * @since 1.0.0
   */
  public ReaderProtocolNotSupportedException(String physicalProtocolName) {
    super("The protocol '" + physicalProtocolName + "' is not supported.");
  }
}
