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
package org.eclipse.keypop.reader;

/**
 * Indicates that a response received from the card during a selection process or a transaction was
 * invalid, or that an ISO 7816-4 card does not support a requested multi-channel operation.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_InvalidCardResponseException">InvalidCardResponseException</a>
 * for the normative contract.
 *
 * @since 2.1.0
 */
public class InvalidCardResponseException extends RuntimeException {

  /**
   * @param message The message to identify the exception context.
   * @since 2.1.0
   */
  public InvalidCardResponseException(String message) {
    super(message);
  }

  /**
   * @param message The message to identify the exception context.
   * @param cause The cause.
   * @since 2.1.0
   */
  public InvalidCardResponseException(String message, Throwable cause) {
    super(message, cause);
  }
}
