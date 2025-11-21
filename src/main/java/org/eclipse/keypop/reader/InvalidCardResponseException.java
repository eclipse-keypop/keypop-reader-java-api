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
 * Indicates that a response received from the card during the command processing was invalid.
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
