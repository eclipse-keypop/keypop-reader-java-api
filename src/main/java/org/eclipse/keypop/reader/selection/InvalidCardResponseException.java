/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.reader.selection;

/**
 * Indicates that a response received from the card during the selection process was invalid.
 *
 * @since 1.0.0
 */
public class InvalidCardResponseException extends RuntimeException {

  /**
   * @param message The message to identify the exception context.
   * @since 1.0.0
   */
  public InvalidCardResponseException(String message) {
    super(message);
  }

  /**
   * @param message The message to identify the exception context.
   * @param cause The cause.
   * @since 1.0.0
   */
  public InvalidCardResponseException(String message, Throwable cause) {
    super(message, cause);
  }
}
